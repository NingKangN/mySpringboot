package com.myDemo.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName LogAspect
 * @Description TODO
 * @Author NingKang
 * @Date 2019/1/22 10:00
 * @Version 1.0
 **/
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.myDemo.service.Action)")
    public void annotationPointCut(){};
    @Around("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("注解拦截   " +"\n"+ annotation.name());

    }




   /* @Before("execution(* com.myDemo.service.*(..))")
public  void before (JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("党阀拦截"+method.getName());


    }*/
}
