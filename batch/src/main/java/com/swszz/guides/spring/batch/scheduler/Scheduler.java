package com.swszz.guides.spring.batch.scheduler;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

/**
 * packageName    : com.swszz.guides.spring.batch.scheduler
 * fileName       : Scheduler
 * author         : 김성원
 * date           : 2023-04-08
 * description    : 각 메소드에 대한 Cron 설정은 @Scheduled 어노테이션을 활용해 직접 구현한다.
 */
public interface Scheduler {
    // TODO: 2023-04-09 크론도 설정으로 빼고 싶은데... 가능하려나
    void run() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException;
}
