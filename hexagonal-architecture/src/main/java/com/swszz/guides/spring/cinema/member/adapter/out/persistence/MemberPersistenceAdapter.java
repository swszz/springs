package com.swszz.guides.spring.cinema.member.adapter.out.persistence;

import com.swszz.guides.spring.cinema.member.application.port.out.LoadMemberPort;
import com.swszz.guides.spring.cinema.member.application.port.out.SaveMemberPasswordPort;
import com.swszz.guides.spring.cinema.member.application.port.out.SaveMemberPort;
import com.swszz.guides.spring.cinema.member.application.port.out.UpdateMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : swszz
 */
@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements LoadMemberPort, SaveMemberPort, SaveMemberPasswordPort, UpdateMemberPort {

    private final SpringDataMemberRepository springDataMemberRepository;
}
