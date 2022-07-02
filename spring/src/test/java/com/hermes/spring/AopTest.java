package com.hermes.spring;

import com.hermes.spring.service.CalcService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

/**
 * @author liu.zongbin
 * @created 2022/6/30 13:34
 */
@SpringBootTest
public class AopTest {

    @Autowired
    private CalcService calcService;

    @Test
    public void aopTest() {
        System.out.println("spring版本：" + SpringVersion.getVersion() + "\t" + "SpringBoot版本：" + SpringBootVersion.getVersion());
        System.out.println();
        this.calcService.div(10, 2);
//        calcService.div(10, 0);
    }
}
