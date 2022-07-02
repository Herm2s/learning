package com.hermes.spring.service.impl;

import com.hermes.spring.service.ServiceA;
import com.hermes.spring.service.ServiceB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author liu.zongbin
 * @created 2022/6/30 15:03
 */
@Slf4j
@Service("a")
public class ServiceAImpl implements ServiceA {

    @Autowired
    private ServiceB serviceB;

    public ServiceAImpl() {
        log.info("------ Bean a创建成功 ------");
    }
}
