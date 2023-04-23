package com.swszz.guides.spring.cinema.member.application;

import com.swszz.guides.spring.cinema.member.application.port.in.BrowseMemberUseCase;
import com.swszz.guides.spring.cinema.member.application.port.out.LoadMemberPort;
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
