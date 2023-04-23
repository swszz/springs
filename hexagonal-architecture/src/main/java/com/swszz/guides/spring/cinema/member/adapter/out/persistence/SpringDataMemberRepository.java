package com.swszz.guides.spring.cinema.member.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : swszz
 */
public interface SpringDataMemberRepository extends JpaRepository<Member, Long> {
}
