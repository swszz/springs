package com.swszz.guides.spring.batch.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName    : com.swszz.guides.spring.batch.model
 * fileName       : Member
 * author         : 김성원
 * date           : 2023-04-06
 * description    :
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Member {
    private String name;
    private Integer age;
}
