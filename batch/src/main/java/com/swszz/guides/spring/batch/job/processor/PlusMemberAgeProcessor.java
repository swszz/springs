package com.swszz.guides.spring.batch.job.processor;

import com.swszz.guides.spring.batch.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

/**
 * packageName    : com.swszz.guides.spring.batch.job.processor
 * fileName       : PlusMemberAgeProcessor
 * author         : 김성원
 * date           : 2023-04-10
 * description    :
 */
@Slf4j
public class PlusMemberAgeProcessor implements ItemProcessor<Member, Member> {
    @Override
    public Member process(Member item) {
        log.info("[BEFORE AGE] : {}", item.getAge());
        item.setAge(item.getAge() + 10);
        log.info("[AFTER AGE] : {}", item.getAge());
        return item;
    }
}
