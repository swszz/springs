package com.swszz.guides.spring.cinema.member.application.port.in;

/**
 * @author : swszz
 */
public interface RegisterMemberUseCase {

    /**
     * @param registerMemberCommand RegisterMemberCommand
     *                              {@link com.swszz.guides.spring.cinema.member.application.port.in.RegisterMemberCommand}
     * @return Member 등록 여부
     * @implSpec RegisterMemberCommand 를 입력으로 받아 데이터베이스에 Member 정보를 저장한다. 해당 메소드는 계정의 등록 여부를 반환한다.
     */
    boolean registerMember(final RegisterMemberCommand registerMemberCommand);
}
