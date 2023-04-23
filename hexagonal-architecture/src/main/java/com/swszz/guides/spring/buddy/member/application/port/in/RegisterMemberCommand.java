package com.swszz.guides.spring.buddy.member.application.port.in;

import com.swszz.guides.spring.buddy.SelfValidating;
import com.swszz.guides.spring.buddy.member.domain.Age;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

/**
 * @author : swszz
 */
@Value
public class RegisterMemberCommand extends SelfValidating<RegisterMemberCommand> {

    @NotNull
    private final String id;
    @NotNull
    private final String password;
    @NotNull
    private final String name;
    @NotNull
    private final Age age;
    @NotNull
    private final String residentRegistrationNumber;


    public RegisterMemberCommand(final String id, final String password, final String name, final Age age, final String residentRegistrationNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.residentRegistrationNumber = residentRegistrationNumber;
        this.validateSelf();
    }
}
