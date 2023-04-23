package com.swszz.guides.spring.cinema.member.adapter.in.web;

import com.swszz.guides.spring.cinema.member.application.port.in.RegisterMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : swszz
 */
@WebAdapter
@RestController
@RequiredArgsConstructor
class RegisterMemberController {

    private final RegisterMemberUseCase registerMemberUseCase;
    private final ApplicationContext applicationContext;

    @PostMapping(value = "member")
    void registerMember(@RequestBody @Validated final RegisterMemberRequest registerMemberRequest) {

    }
}
