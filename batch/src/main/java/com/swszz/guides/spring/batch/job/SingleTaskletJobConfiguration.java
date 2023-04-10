package com.swszz.guides.spring.batch.job;

import com.swszz.guides.spring.batch.job.tasklet.SimpleTasklet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * packageName    : com.swszz.guides.spring.batch.job
 * fileName       : TaskletJobConfiguration
 * author         : 김성원
 * date           : 2023-04-08
 * description    :
 */
@Slf4j
@Configuration
public class SingleTaskletJobConfiguration {

//    @Bean
//    public Scheduler singleTaskletJobScheduler(Job singleTaskletJob, JobLauncher jobLauncher) {
//        return new DefaultJobScheduler(singleTaskletJob, jobLauncher);
//    }

    @Bean
    public Job singleTaskletJob(JobRepository jobRepository, Step singleTaskletStep) {
        return new JobBuilder("singleTaskletJob", jobRepository)
                .flow(singleTaskletStep)
                .end()
                .build();
    }

    @Bean
    public Step singleTaskletStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("singleTaskletStep", jobRepository)
                .tasklet(new SimpleTasklet(), transactionManager)
                .build();
    }
}
