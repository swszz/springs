package com.swszz.guides.spring.cinema.member.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author : swszz
 */
@Entity
class Member {
    @Id
    private Long id;
}
