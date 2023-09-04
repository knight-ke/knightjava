package com.knight.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    @Pointcut("@annotation(com.knight.aop.ModelView)")
    public void pointcut(){}

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowable(Throwable e){
        log.error("切面发生了异常： ", e);
        if (e instanceof CustomeException){
            throw ModelViewException.transfer((CustomeException) e);
        }
    }
}
