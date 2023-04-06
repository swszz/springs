package com.swszz.guides.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Batch 5부터 @EnableBatchProcessing은 Boot Autoconfiguraiton 에서 지원 <br>
 * 디테일하게 컨트롤하고 싶을 경우 DefaultBatchConfiguration를 활용하는 것으로 함 <br>
 *
 * @reference : https://github.com/spring-projects/spring-boot/issues/32330
 */
@SpringBootApplication
public class BatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

}
