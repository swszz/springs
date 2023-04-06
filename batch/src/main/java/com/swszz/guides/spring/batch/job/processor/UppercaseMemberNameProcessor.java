package com.swszz.guides.spring.batch.job.processor;

import com.swszz.guides.spring.batch.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * packageName    : com.swszz.guides.spring.batch.job.processor
 * fileName       : UppercaseMemberNameProcessor
 * author         : 김성원
 * date           : 2023-04-06
 * description    :
 */
@Slf4j
public class UppercaseMemberNameProcessor implements ItemProcessor<Member, Member> {
    @Override
    public Member process(Member item) {
        log.info("[BEFORE NAME] : {}", item.getName());
        item.setName(item.getName().toUpperCase());
        log.info("[AFTER NAME] : {}", item.getName());
        return item;
    }
}
