package com.swszz.guides.spring.batch.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * packageName    : com.swszz.guides.spring.batch.scheduler
 * fileName       : SimpleJobScheduler
 * author         : 김성원
 * date           : 2023-04-06
 * description    :
 */
@Component
@RequiredArgsConstructor
public class SimpleJobScheduler {

    private final Job simpleJob;
    private final JobLauncher jobLauncher;

    @Scheduled(cron = "0/5 * * * * ?")
    public void run() {
        final JobParameters jobParameters = new JobParametersBuilder()
                .addLocalDateTime("startedAt", LocalDateTime.now())
                .toJobParameters();
        try {
            jobLauncher.run(simpleJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
}
