package com.swszz.guides.spring.batch.entity;

import com.swszz.guides.spring.batch.entity.listener.SequentialUUIDEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;
import java.util.UUID;

/**
 * packageName    : com.swszz.guides.spring.batch.entity
 * fileName       : AbstractSequentialUUIDEntity
 * author         : 김성원
 * date           : 2023-04-06
 * description    :
 */
@Getter
@MappedSuperclass
@ToString(callSuper = true)
@EntityListeners({SequentialUUIDEntityListener.class, AuditingEntityListener.class})
public abstract class AbstractSequentialUUIDEntity extends AbstractAuditingEntity {

    @Id
    @Column(columnDefinition = ColumnDefinitions.BINARY_16)
    private UUID id;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final AbstractSequentialUUIDEntity that = (AbstractSequentialUUIDEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
