package com.swszz.guides.spring.batch.job;

import com.swszz.guides.spring.batch.job.tasklet.SimpleTasklet;
import com.swszz.guides.spring.batch.job.tasklet.SimplerTasklet;
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
 * fileName       : MultipleTaskletJobConfiguration
 * author         : 김성원
 * date           : 2023-04-09
 * description    :
 */
@Slf4j
@Configuration
public class MultipleTaskletJobConfiguration {

//    @Bean
//    public Scheduler multipleTaskletJobScheduler(Job multipleTaskletJob, JobLauncher jobLauncher) {
//        return new DefaultJobScheduler(multipleTaskletJob, jobLauncher);
//    }

    @Bean
    public Job multipleTaskletJob(JobRepository jobRepository, Step firstTaskletStep, Step secondTaskletStep) {
        return new JobBuilder("multipleTaskletJob", jobRepository)
                .start(firstTaskletStep)
                .next(secondTaskletStep)
                .build();
    }

    @Bean
    public Step firstTaskletStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("firstTaskletStep", jobRepository)
                .tasklet(new SimpleTasklet(), transactionManager)
                .build();
    }

    @Bean
    public Step secondTaskletStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("secondTaskletStep", jobRepository)
                .tasklet(new SimplerTasklet(), transactionManager)
                .build();
    }
}
