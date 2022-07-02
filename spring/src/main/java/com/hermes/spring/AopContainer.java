package com.hermes.spring;

import com.hermes.spring.service.ServiceA;
import com.hermes.spring.service.ServiceB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liu.zongbin
 * @created 2022/6/30 16:17
 */
@Slf4j
public class AopContainer {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.hermes.spring.*")) {
            ServiceA a = context.getBean("a", ServiceA.class);
            ServiceB b = context.getBean("b", ServiceB.class);
            log.info("获取Bean成功...");
        }
    }
}
