package com.swszz.guides.spring.batch.job.tasklet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * packageName    : com.swszz.guides.spring.batch.job.tasklet
 * fileName       : SimplerTasklet
 * author         : 김성원
 * date           : 2023-04-09
 * description    :
 */
@Slf4j
public class SimplerTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("[CALLED EXECUTE IN SIMPLER TASKLET]");
        return RepeatStatus.FINISHED;
    }
}
