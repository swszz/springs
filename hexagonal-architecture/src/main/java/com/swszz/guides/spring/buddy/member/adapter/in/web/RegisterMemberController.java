package com.swszz.guides.spring.buddy.member.adapter.in.web;

import com.swszz.guides.spring.buddy.WebAdapter;
import com.swszz.guides.spring.buddy.member.application.port.in.RegisterMemberCommand;
import com.swszz.guides.spring.buddy.member.application.port.in.RegisterMemberUseCase;
import com.swszz.guides.spring.buddy.member.domain.Age;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "member")
    ResponseEntity<Boolean> registerMember(@RequestBody @Validated final RegisterMemberRequest registerMemberRequest) {

        final RegisterMemberCommand registerMemberCommand = new RegisterMemberCommand(
                registerMemberRequest.getId(),
                registerMemberRequest.getPassword(),
                registerMemberRequest.getName(),
                Age.of(registerMemberRequest.getAge()),
                registerMemberRequest.getResidentRegistrationNumber()
        );

        final boolean registered = registerMemberUseCase.registerMember(registerMemberCommand);

        return ResponseEntity.ok(registered);
    }
}
