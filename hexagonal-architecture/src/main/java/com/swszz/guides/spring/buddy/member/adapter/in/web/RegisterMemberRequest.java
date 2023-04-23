package com.swszz.guides.spring.buddy.member.adapter.in.web;

import jakarta.validation.constraints.*;
import jdk.jfr.Description;
import lombok.*;

/**
 * @author : swszz
 */
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class RegisterMemberRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9].{4,16}$")
    @Description("사용자 아이디 (공백과 null을 허용하지 않으며, 영문, 숫자으로 구성된 4~16자리 문자여야 합니다.)")
    private String id;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$")
    @Description("비밀번호 (공백과 null을 허용하지 않으며,  영문 대&소문자, 숫자, 특수문자로 구성된 8~16자리 문자여야 합니다.)")
    private String password;

    @NotNull
    @Min(0)
    @Max(255)
    @Description("나이 (0~255 사이의 숫자여야 합니다.)")
    private Integer age;

    @NotBlank
    @Size(min = 1, max = 255)
    @Description("사용자 이름 (공백과 null을 허용하지 않으며, 1~255자의 문자여야 합니다.)")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[0-9]{6}-[1-4][0-9]{6}$")
    @Description("주민등록번호 ('000000-0000000'의 입력 가능하며 뒷자리 중 맨 앞자리(성별)는 1~4만 입력 가능합니다.)")
    private String residentRegistrationNumber;
}
