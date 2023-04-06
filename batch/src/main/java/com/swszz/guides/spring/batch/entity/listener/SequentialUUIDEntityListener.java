package com.swszz.guides.spring.batch.entity.listener;

import com.fasterxml.uuid.Generators;
import com.swszz.guides.spring.batch.entity.AbstractSequentialUUIDEntity;
import jakarta.persistence.PrePersist;
import lombok.SneakyThrows;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * packageName    : com.swszz.guides.spring.batch.entity
 * fileName       : SequentialUUIDEntityListener
 * author         : 김성원
 * date           : 2023-04-06
 * description    :
 */
public class SequentialUUIDEntityListener {

    @SneakyThrows
    @PrePersist
    public void prePersist(Object o) {
        Assert.notNull(o, "Entity must not be null.");

        if (o instanceof AbstractSequentialUUIDEntity) {
            final Field field = ReflectionUtils.findField(o.getClass(), "id");
            Assert.notNull(field, "Entity field not be null.");

            final Class<?> type = field.getType();
            Assert.isTrue(UUID.class.equals(type), "not UUID field");

            field.setAccessible(true);
            field.set(o, Generators.timeBasedGenerator().generate());
        }
    }
}
