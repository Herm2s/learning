package com.hermes.spring3.controller;

import com.hermes.spring3.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu.zongbin
 * @since 2022/12/14
 */
@RestController
public class HelloController {

    @Autowired
    private AppConfig appConfig;

    @GetMapping("/test")
    public String test() {
        // 使用appFactoryBean，返回的是FactoryBean生产的bean对象
        Object myBean = appConfig.getApplicationContext().getBean("appFactoryBean");
        //使用&appFactoryBean，返回的是FactoryBean对象
        Object appFactoryBean = appConfig.getApplicationContext().getBean("&appFactoryBean");
        return "hello";
    }
}
