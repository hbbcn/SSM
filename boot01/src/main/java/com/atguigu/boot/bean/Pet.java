package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author hqb
 * @Date 2021/10/26 16:57
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Component
public class Pet {

    private String name;


}

