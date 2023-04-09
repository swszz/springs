package com.swszz.guides.spring.batch.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * packageName    : com.swszz.guides.spring.batch.scheduler
 * fileName       : DefaultJobScheduler
 * author         : 김성원
 * date           : 2023-04-09
 * description    :
 */
public class DefaultJobScheduler extends AbstractScheduler {

    public DefaultJobScheduler(Job job, JobLauncher jobLauncher) {
        super(job, jobLauncher);
    }

    @Override
    @Scheduled(cron = "0/5 * * * * ?")
    public void run() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        final JobParameters jobParameters = new JobParametersBuilder()
                .addLocalDateTime("startedAt", LocalDateTime.now())
                .toJobParameters();
        jobLauncher.run(job, jobParameters);
    }
}
