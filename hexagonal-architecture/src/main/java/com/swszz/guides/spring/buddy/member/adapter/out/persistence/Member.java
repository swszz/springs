package com.swszz.guides.spring.buddy.member.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author : swszz
 */
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userId;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private Integer age;

    public static Member createNewMember(final String userId, final String name, final String password, final Integer age) {
        return new Member(null, userId, name, password, age);
    }
}
