package com.swszz.guides.spring.buddy.member.domain;

import lombok.Value;

/**
 * @author : swszz
 */
@Value
public class Age {
    public static Age MINIMUM = Age.of(19);

    private final Integer age;

    public static Age of(int value) {
        return new Age(value);
    }

    public boolean isAllowed() {
        return this.age.compareTo(MINIMUM.age) >= 0;
    }
}
