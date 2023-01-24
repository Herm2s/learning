package com.hermes.springsecurity1;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StopWatch;

class SpringSecurity1ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void passwordEncodeTest() {
        String password = "123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        passwordEncoder.matches(password, encodedPassword);
        stopWatch.stop();
        System.out.println(stopWatch.shortSummary());
        System.out.println(stopWatch.getLastTaskTimeMillis());
    }
}
