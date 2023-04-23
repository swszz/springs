package com.swszz.guides.spring.buddy.member.application.port.out;

import com.swszz.guides.spring.buddy.SelfValidating;
import com.swszz.guides.spring.buddy.member.domain.Age;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

/**
 * @author : swszz
 */
@Value
public class SaveMemberCommand extends SelfValidating<SaveMemberCommand> {

    @NotNull
    private final String id;
    @NotNull
    private final String password;
    @NotNull
    private final Age age;
    @NotNull
    private final String name;
    @NotNull
    private final String residentRegistrationNumber;

    public SaveMemberCommand(final String id, final String password, final Age age, final String name, final String residentRegistrationNumber) {
        this.id = id;
        this.password = password;
        this.age = age;
        this.name = name;
        this.residentRegistrationNumber = residentRegistrationNumber;
        this.validateSelf();
    }
}
