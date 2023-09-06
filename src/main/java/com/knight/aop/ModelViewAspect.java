package com.knight.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    @Pointcut("@annotation(com.knight.aop.ModelView)")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        log.info("before");
        log.info(joinPoint.getKind());
        log.info(joinPoint.toString());
        log.info(Arrays.toString(joinPoint.getArgs()));
        log.info(String.valueOf(joinPoint.getClass()));
        log.info(String.valueOf(joinPoint.getSignature()));
        log.info(String.valueOf(joinPoint.getTarget()));
    }

    @After("pointcut()")
    public void afterPointcut(){
        log.info("after");
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowable(Throwable e){
        log.error("切面发生了异常： ", e);
        if (e instanceof CustomeException){
            throw ModelViewException.transfer((CustomeException) e);
        }
    }
}
