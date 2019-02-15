package com.myDemo.service;

import java.lang.annotation.*;

/**
 * @ClassName Action
 * @Description TODO
 * @Author NingKang
 * @Date 2019/1/22 11:12
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
