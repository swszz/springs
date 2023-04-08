package com.swszz.guides.spring.batch.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;

/**
 * packageName    : com.swszz.guides.spring.batch.scheduler
 * fileName       : AbstractScheduler
 * author         : 김성원
 * date           : 2023-04-08
 * description    :
 */
public abstract class AbstractScheduler implements Scheduler {

    protected final Job job;
    protected final JobLauncher jobLauncher;

    protected AbstractScheduler(Job job, JobLauncher jobLauncher) {
        this.job = job;
        this.jobLauncher = jobLauncher;
    }
}
