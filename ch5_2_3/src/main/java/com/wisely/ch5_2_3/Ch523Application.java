package com.wisely.ch5_2_3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Ch523Application {

    @RequestMapping(value = "/myindex",produces = {"application/json;charset=UTF-8"})
    public  String index(){
     return "This book's name is:" +"and book 's author is:";
    }

    public static void main(String[] args) {

        SpringApplication.run(Ch523Application.class, args);

    }

}

