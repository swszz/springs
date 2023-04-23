package com.swszz.guides.spring.cinema.member.application;

import com.swszz.guides.spring.cinema.member.application.port.in.RegisterMemberCommand;
import com.swszz.guides.spring.cinema.member.application.port.in.RegisterMemberUseCase;
import com.swszz.guides.spring.cinema.member.application.port.out.SaveMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : swszz
 */
@Service
@RequiredArgsConstructor
class RegisterMemberService implements RegisterMemberUseCase {

    private final SaveMemberPort saveMemberPort;

    @Override
    public boolean registerMember(final RegisterMemberCommand registerMemberCommand) {
        return false;
    }
}
