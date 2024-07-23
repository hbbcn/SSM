package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName Car
 * @Description TODO
 * @Author hqb
 * @Date 2021/10/26 19:57
 * @Version 1.0
 */

/**
 * 只有在容器中的组件,才会拥有springBoot提供的强大功能
 */
//@Component
@Data
@ConfigurationProperties(value = "mycar")
public class Car {

    private String price;
    private String brand;


/*    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                '}';
    }*/
}

