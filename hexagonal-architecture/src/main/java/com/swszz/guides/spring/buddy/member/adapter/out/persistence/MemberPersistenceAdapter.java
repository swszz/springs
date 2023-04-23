package com.swszz.guides.spring.buddy.member.adapter.out.persistence;

import com.swszz.guides.spring.buddy.PersistenceAdapter;
import com.swszz.guides.spring.buddy.member.application.port.out.*;
import lombok.RequiredArgsConstructor;

/**
 * @author : swszz
 */
@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements LoadMemberPort, SaveMemberPort, SaveMemberPasswordPort, UpdateMemberPort {

    private final SpringDataMemberRepository springDataMemberRepository;

    @Override
    public boolean save(final SaveMemberCommand saveMemberCommand) {

        final Member member = Member.createNewMember(saveMemberCommand.getId(),
                saveMemberCommand.getName(),
                saveMemberCommand.getPassword(),
                saveMemberCommand.getAge().getAge());

        springDataMemberRepository.save(member);

        return true;
    }
}
