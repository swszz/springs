package com.swszz.guides.spring.cinema.ticket.application;

import com.swszz.guides.spring.cinema.ticket.application.port.in.ModifyMemberUseCase;
import com.swszz.guides.spring.cinema.ticket.application.port.out.LoadMemberPort;
import com.swszz.guides.spring.cinema.ticket.application.port.out.UpdateMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : swszz
 */
@Service
@RequiredArgsConstructor
public class ModifyMemberService implements ModifyMemberUseCase {

    private final LoadMemberPort loadMemberPort;
    private final UpdateMemberPort updateMemberPort;
}
