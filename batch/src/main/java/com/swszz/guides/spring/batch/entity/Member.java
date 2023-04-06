package com.swszz.guides.spring.batch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.util.Assert;

/**
 * packageName    : com.swszz.guides.spring.batch.entity
 * fileName       : Member
 * author         : 김성원
 * date           : 2023-04-06
 * description    :
 */
@Getter
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends AbstractSequentialUUIDEntity {

    @Setter
    @Column
    private String name;

    @Column
    private Integer age;

    @Builder(builderClassName = "ByNameAndAge", builderMethodName = "ByNameAndAge")
    private Member(final String name, final Integer age) {
        Assert.notNull(name, "name not be null");
        Assert.notNull(age, "age not be null");
        this.name = name;
        this.age = age;
    }
}
