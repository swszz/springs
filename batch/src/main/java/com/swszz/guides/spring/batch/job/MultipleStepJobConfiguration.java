package com.swszz.guides.spring.batch.job;

import com.swszz.guides.spring.batch.job.lisenter.JobCompletionNotificationListener;
import com.swszz.guides.spring.batch.job.processor.PlusMemberAgeProcessor;
import com.swszz.guides.spring.batch.job.processor.UppercaseMemberNameProcessor;
import com.swszz.guides.spring.batch.model.Member;
import com.swszz.guides.spring.batch.scheduler.DefaultJobScheduler;
import com.swszz.guides.spring.batch.scheduler.Scheduler;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * packageName    : com.swszz.guides.spring.batch.job
 * fileName       : MultipleStepJobConfiguration
 * author         : 김성원
 * date           : 2023-04-10
 * description    :
 */

@Configuration
public class MultipleStepJobConfiguration {

    @Bean
    public Scheduler multipleStepJobScheduler(Job multipleStepJob, JobLauncher jobLauncher) {
        return new DefaultJobScheduler(multipleStepJob, jobLauncher);
    }

    @Bean
    public Job multipleStepJob(JobRepository jobRepository, Step firstStep, Step secondStep) {
        return new JobBuilder("multipleStepJob", jobRepository)
                .listener(new JobCompletionNotificationListener())
                .start(firstStep)
                .next(secondStep)
                .build();
    }

    @Bean
    public Step firstStep(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager) {
        return new StepBuilder("firstStep", jobRepository)
                .<Member, Member>chunk(1, transactionManager)
                .reader(firstStepReader())
                .processor(new UppercaseMemberNameProcessor())
                .writer(firstStepWriter())
                .build();
    }

    @Bean
    public Step secondStep(JobRepository jobRepository,
                           PlatformTransactionManager transactionManager) {
        return new StepBuilder("secondStep", jobRepository)
                .<Member, Member>chunk(1, transactionManager)
                .reader(secondStepReader())
                .processor(new PlusMemberAgeProcessor())
                .writer(secondStepWriter())
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<Member> firstStepReader() {
        return new FlatFileItemReaderBuilder<Member>().name("firstStepReader")
                .resource(new ClassPathResource("input/simple-member.txt"))
                .delimited()
                .names(new String[]{"name", "age"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Member.class);
                }})
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemWriter<Member> firstStepWriter() {
        return new FlatFileItemWriterBuilder<Member>().name("firstStepWriter")
                .resource(new FileSystemResource("src/main/resources/output/simple-member.csv"))
                .lineAggregator(new DelimitedLineAggregator<>() {{
                    setDelimiter(",");
                    setFieldExtractor(new BeanWrapperFieldExtractor<Member>() {{
                        setNames(new String[]{"name", "age"});
                    }});
                }})
                .encoding("UTF-8")
                .append(true)
                .lineSeparator("\r\n")
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<Member> secondStepReader() {
        return new FlatFileItemReaderBuilder<Member>().name("secondStepReader")
                .resource(new FileSystemResource("src/main/resources/output/simple-member.csv"))
                .delimited()
                .names(new String[]{"name", "age"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Member.class);
                }})
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemWriter<Member> secondStepWriter() {
        return new FlatFileItemWriterBuilder<Member>().name("secondStepWriter")
                .resource(new FileSystemResource("src/main/resources/output/simple-member-second.csv"))
                .lineAggregator(new DelimitedLineAggregator<>() {{
                    setDelimiter(",");
                    setFieldExtractor(new BeanWrapperFieldExtractor<Member>() {{
                        setNames(new String[]{"name", "age"});
                    }});
                }})
                .encoding("UTF-8")
                .append(true)
                .lineSeparator("\r\n")
                .build();
    }
}
