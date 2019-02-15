package com.myDemo.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName AopConfig
 * @Description TODO
 * @Author NingKang
 * @Date 2019/1/22 10:26
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.myDemo")
@EnableAspectJAutoProxy
public class AopConfig {
}
