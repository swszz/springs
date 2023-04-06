package com.swszz.guides.spring.batch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * packageName    : com.swszz.guides.spring.batch.entity
 * fileName       : AbstractAuditingEntity
 * author         : 김성원
 * date           : 2023-04-06
 * description    :
 */
@Getter
@MappedSuperclass
@ToString(callSuper = true)
public abstract class AbstractAuditingEntity {

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
