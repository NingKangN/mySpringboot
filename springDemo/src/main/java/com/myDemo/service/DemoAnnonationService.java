package com.myDemo.service;

import org.springframework.stereotype.Service;


/**
 * @ClassName DemoAnnonationService
 * @Description TODO
 * @Author NingKang
 * @Date 2019/1/22 9:55
 * @Version 1.0
 **/
@Service
public class DemoAnnonationService {
    @Action(name = "注解拦截add操作")
    public void add(){}
}
