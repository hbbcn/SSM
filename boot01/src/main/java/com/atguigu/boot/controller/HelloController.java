package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author hqb
 * @Date 2021/10/25 21:19
 * @Version 1.0
 */
//@ResponseBody
//@Controller

@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(@RequestParam String name) {

        log.info("请求进来了");
        return "Hello, Spring Boot 2 ! " + name;
    }

    @ResponseBody
    @RequestMapping("/person")
    public Person testPerson(Person person){

        return person;
    }

}

