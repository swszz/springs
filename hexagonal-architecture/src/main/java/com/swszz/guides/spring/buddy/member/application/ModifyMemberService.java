package com.swszz.guides.spring.buddy.member.application;

import com.swszz.guides.spring.buddy.member.application.port.in.ModifyMemberPasswordUseCase;
import com.swszz.guides.spring.buddy.member.application.port.in.ModifyMemberUseCase;
import com.swszz.guides.spring.buddy.member.application.port.out.LoadMemberPort;
import com.swszz.guides.spring.buddy.member.application.port.out.SaveMemberPasswordPort;
import com.swszz.guides.spring.buddy.member.application.port.out.UpdateMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : swszz
 */
@Service
@RequiredArgsConstructor
public class ModifyMemberService implements ModifyMemberUseCase, ModifyMemberPasswordUseCase {
    private final LoadMemberPort loadMemberPort;
    private final SaveMemberPasswordPort saveMemberPasswordPort;
    private final UpdateMemberPort updateMemberPort;
}
