package com.swszz.guides.spring.batch.job;

import com.swszz.guides.spring.batch.job.lisenter.JobCompletionNotificationListener;
import com.swszz.guides.spring.batch.job.processor.UppercaseMemberNameProcessor;
import com.swszz.guides.spring.batch.model.Member;
import com.swszz.guides.spring.batch.scheduler.DefaultJobScheduler;
import com.swszz.guides.spring.batch.scheduler.Scheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.builder.TaskletStepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * packageName    : com.swszz.guides.spring.batch.job
 * fileName       : TestJobConfiguration
 * author         : 김성원
 * date           : 2023-04-06
 * description    :
 */
@Slf4j
@Configuration
public class SingleStepJobConfiguration {

    @Bean
    public Scheduler singleStepJobScheduler(Job singleStepJob, JobLauncher jobLauncher) {
        return new DefaultJobScheduler(singleStepJob, jobLauncher);
    }

    @Bean
    public Job singleStepJob(JobRepository jobRepository, Step singleStep) {
        return new JobBuilder("singleStepJob", jobRepository)
                .listener(new JobCompletionNotificationListener())
                .flow(singleStep)
                .end()
                .build();
    }

    @Bean
    public Step singleStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("singleStep", jobRepository)
                .<Member, Member>chunk(1, transactionManager)
                .reader(singleStepReader())
                .processor(new UppercaseMemberNameProcessor())
                .writer(singleStepWriter())
                .build();
    }

    /*
     * @StepScope 병렬 처리가 추가될 경우 각 Step의 상태를 침범하지 않도록 함 (late binding)
     * - 병렬 처리가 추가될 경우 각 Step의 상태를 침범하지 않도록 함 (late binding)
     * - 단, 해당 어노테이션을 사용할 경우 구현체를 직접 반환하도록 해야 함
     * -- 인터페이스를 반환하는 경우 메소드를 찾지 못해 의도와 다르게 동작할 가능성이 존재함 (https://jojoldu.tistory.com/132)
     */
    @Bean
    @StepScope
    public FlatFileItemReader<Member> singleStepReader() {
        return new FlatFileItemReaderBuilder<Member>().name("reader")
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
    public FlatFileItemWriter<Member> singleStepWriter() {
        return new FlatFileItemWriterBuilder<Member>().name("writer")
                .resource(new FileSystemResource("src/main/resources/output/simple-member.txt"))
                .lineAggregator(new PassThroughLineAggregator<>())
                .encoding("UTF-8")
                .append(true)
                .lineSeparator("\n")
                .build();
    }
}
