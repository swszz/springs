package com.swszz.guides.spring.cinema.ticket.adapter.in.web;

import com.swszz.guides.spring.cinema.ticket.application.port.in.BrowseMemberUseCase;
import com.swszz.guides.spring.cinema.ticket.application.port.in.ModifyMemberUseCase;
import com.swszz.guides.spring.cinema.ticket.application.port.in.RegisterMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : swszz
 */
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final BrowseMemberUseCase browseMemberUseCase;
    private final ModifyMemberUseCase modifyMemberUseCase;
    private final RegisterMemberUseCase registerMemberUseCase;
}
