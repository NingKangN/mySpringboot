package com.wisely;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class Ch72Application {

    @RequestMapping(value = "/my")
    public String index(Model model){
        Person person=new Person("aa",11);
        List<Person> list=new ArrayList<Person>();
        Person p1=new Person("xx",11);
        Person p2=new Person("yy",22);
        Person p3=new Person("zz",33);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        model.addAttribute("singlePerson",person);
        model.addAttribute("person",list);
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch72Application.class, args);
    }

    @RequestMapping(value = "/export")
    public String export(Model model){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename=");

        Person person=new Person("aa",11);
        List<Person> list=new ArrayList<Person>();
        Person p1=new Person("xx",11);
        Person p2=new Person("yy",22);
        Person p3=new Person("zz",33);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        model.addAttribute("singlePerson",person);
        model.addAttribute("person",list);
        return "index";
    }

}

