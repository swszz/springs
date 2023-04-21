package com.swszz.guides.spring.cinema.ticket.adapter.out.persistence;

import com.swszz.guides.spring.cinema.ticket.application.port.out.LoadMemberPort;
import com.swszz.guides.spring.cinema.ticket.application.port.out.SaveMemberPort;
import com.swszz.guides.spring.cinema.ticket.application.port.out.UpdateMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : swszz
 */
@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements LoadMemberPort, SaveMemberPort, UpdateMemberPort {

    private final SpringDataMemberRepository springDataMemberRepository;
}
