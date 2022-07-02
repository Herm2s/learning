package com.hermes.spring.service.impl;

import com.hermes.spring.service.ServiceA;
import com.hermes.spring.service.ServiceB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liu.zongbin
 * @created 2022/6/30 15:04
 */
@Slf4j
@Service("b")
public class ServiceBImpl implements ServiceB {

    @Autowired
    private ServiceA serviceA;

    public ServiceBImpl( ) {
       log.info("------ Bean b创建成功 ------");
    }
}
