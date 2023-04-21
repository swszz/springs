package com.swszz.guides.spring.cinema.ticket.application;

import com.swszz.guides.spring.cinema.ticket.application.port.in.BrowseMemberUseCase;
import com.swszz.guides.spring.cinema.ticket.application.port.in.ModifyMemberUseCase;
import com.swszz.guides.spring.cinema.ticket.application.port.in.RegisterMemberUseCase;
import com.swszz.guides.spring.cinema.ticket.application.port.out.LoadMemberPort;
import com.swszz.guides.spring.cinema.ticket.application.port.out.SaveMemberPort;
import com.swszz.guides.spring.cinema.ticket.application.port.out.UpdateMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : swszz
 */
@Service
@RequiredArgsConstructor
public class MemberService implements BrowseMemberUseCase, ModifyMemberUseCase, RegisterMemberUseCase {
    private final LoadMemberPort loadMemberPort;
    private final SaveMemberPort saveMemberPort;
    private final UpdateMemberPort updateMemberPort;
}
