package com.swszz.guides.spring.buddy.member.application.port.out;

/**
 * @author : swszz
 */
public interface SaveMemberPort {

    /**
     * @param saveMemberCommand SaveMemberCommand
     *                          {@link com.swszz.guides.spring.buddy.member.application.port.out.SaveMemberCommand}
     * @return Member 저장 여부
     * @implSpec SaveMemberCommand 를 입력으로 받아 데이터베이스에 Member 정보를 저장한다. 해당 메소드는 계정의 등록 여부를 반환한다.
     */
    boolean save(final SaveMemberCommand saveMemberCommand);
}
