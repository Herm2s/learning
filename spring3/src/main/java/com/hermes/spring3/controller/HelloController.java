package com.hermes.spring3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu.zongbin
 * @since 2022/12/14
 */
@RestController
public class HelloController {

    @GetMapping("/test")
    public String test() {
        return "hello";
    }
}
