package com.swszz.guides.spring.buddy;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Adapter Component 중 Persistence 와 관련된 요소를 명시합니다.
 * Persistence Adapter 는 아래와 같은 역할을 수행합니다.
 * <p>
 * 1. 입력을 받는다
 * 2. 입력을 데이터베이스 포맷으로 매핑한다 (Command to Entity)
 * 3. 입력을 데이터베이스로 보낸다
 * 4. 데이터베이스 출력을 애플리케이션 포맷으로 매핑한다
 * 5. 출력을 반환한다
 * <p>
 *
 * @author : swszz
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PersistenceAdapter {

    @AliasFor(annotation = Component.class)
    String value() default "";

}
