package com.swszz.guides.spring.cinema.ticket.application;

import com.swszz.guides.spring.cinema.ticket.application.port.in.BrowseMemberUseCase;
import com.swszz.guides.spring.cinema.ticket.application.port.out.LoadMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : swszz
 */
@Service
@RequiredArgsConstructor
public class BrowseMemberService implements BrowseMemberUseCase {
    private final LoadMemberPort loadMemberPort;
}
