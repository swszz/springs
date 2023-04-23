package com.swszz.guides.spring.buddy.member.application;

import com.swszz.guides.spring.buddy.member.application.port.in.RegisterMemberCommand;
import com.swszz.guides.spring.buddy.member.application.port.in.RegisterMemberUseCase;
import com.swszz.guides.spring.buddy.member.application.port.out.SaveMemberCommand;
import com.swszz.guides.spring.buddy.member.application.port.out.SaveMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author : swszz
 */
@Service
@RequiredArgsConstructor
class RegisterMemberService implements RegisterMemberUseCase {

    private final SaveMemberPort saveMemberPort;

    @Override
    public boolean registerMember(final RegisterMemberCommand registerMemberCommand) {
        Assert.isTrue(registerMemberCommand.getAge().isAllowed(), "not allowed age.");

        final SaveMemberCommand saveMemberCommand =
                new SaveMemberCommand(registerMemberCommand.getId(),
                        registerMemberCommand.getPassword(),
                        registerMemberCommand.getAge(),
                        registerMemberCommand.getName(),
                        registerMemberCommand.getResidentRegistrationNumber());

        return saveMemberPort.save(saveMemberCommand);
    }
}
