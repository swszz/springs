package com.swszz.guides.spring.cinema.ticket.application;

import com.swszz.guides.spring.cinema.ticket.application.port.in.RegisterMemberUseCase;
import com.swszz.guides.spring.cinema.ticket.application.port.out.SaveMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : swszz
 */
@Service
@RequiredArgsConstructor
public class RegisterMemberService implements RegisterMemberUseCase {

    private final SaveMemberPort saveMemberPort;
}
