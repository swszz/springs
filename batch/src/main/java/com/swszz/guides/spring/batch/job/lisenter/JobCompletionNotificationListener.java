package com.swszz.guides.spring.batch.job.lisenter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * packageName    : com.swszz.guides.spring.batch.job.lisenter
 * fileName       : JobCompletionNotificationListener
 * author         : 김성원
 * date           : 2023-04-06
 * description    :
 */
@Slf4j
public class JobCompletionNotificationListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("[JOB EXECUTION STATUS] : {}", jobExecution.getStatus());
    }


    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("[JOB EXECUTION STATUS] : {}", jobExecution.getStatus());
    }
}
