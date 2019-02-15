package com.myDemo.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author NingKang
 * @Date 2019/1/22 10:28
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnonationService bean = context.getBean(DemoAnnonationService.class);
        bean.add();
        context.close();


    }
}
