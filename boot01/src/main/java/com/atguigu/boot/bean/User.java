package com.atguigu.boot.bean;

import lombok.*;

/**
 * @ClassName User
 * @Description TODO
 * @Author hqb
 * @Date 2021/10/26 16:22
 * @Version 1.0
 */


@Data
@ToString
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private String name;
    private int age;
    private Pet pet;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

