package com.hermes.springsecurity1.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author liu.zongbin
 * @since 2023/1/26
 */
@Service
public class HomeService {

    @PreAuthorize("hasRole('ADMIN')")
    public String sayHello() {
        return "Hello!";
    }
}
