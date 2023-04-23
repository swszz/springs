package com.swszz.guides.spring.buddy;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Adapter Component 중 Web 과 관련된 요소를 명시합니다.
 * Web Adapter 는 아래와 같은 역할을 수행합니다.
 * <p>
 * 1. HTTP 요청을 Java 객체로 매핑
 * 2. 권한 검사
 * 3. 입력 유효성 검증
 * 4. 입력을 유즈케이스의 입력 모델로 매핑
 * 5. 윺스 케이스 호출
 * 6. 유스 케이스의 출력을 HTTP로 매핑
 * 7. HTTP 응답을 반환
 * <p>
 *
 * @author : swszz
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface WebAdapter {

    @AliasFor(annotation = Component.class)
    String value() default "";

}
