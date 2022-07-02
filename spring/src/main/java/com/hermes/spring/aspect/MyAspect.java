package com.hermes.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author liu.zongbin
 * @created 2022/6/30 13:21
 */
@Aspect
@Component
public class MyAspect {

    @Before("execution(public int com.hermes.spring.service.impl.CalcServiceImpl.*(..))")
    public void beforeNotify() {
        System.out.println("******** @Before：我是前置通知\n");
    }

    @After("execution(public int com.hermes.spring.service.impl.CalcServiceImpl.*(..))")
    public void afterNotify() {
        System.out.println("******** @After：我是后置通知\n");
    }

    @AfterReturning("execution(public int com.hermes.spring.service.impl.CalcServiceImpl.*(..))")
    public void afterReturningNotify() {
        System.out.println("******** @AfterReturning：我是返回后通知\n");
    }

    @AfterThrowing("execution(public int com.hermes.spring.service.impl.CalcServiceImpl.*(..))")
    public void afterThrowingNotify() {
        System.out.println("******** @AfterThrowing：我是异常通知\n");
    }

    @Around("execution(public int com.hermes.spring.service.impl.CalcServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retValue;
        System.out.println("******** @Around：我是环绕通知之前AAA");
        retValue = proceedingJoinPoint.proceed();
        System.out.println("******** @Around：我是环绕通知之后BBB");
        return retValue;
    }
}
