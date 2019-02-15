package com.wisely.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author NingKang
 * @Date 2019/2/14 10:13
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class User {
    private String name;
    private String  birth;
    private String code;

}
