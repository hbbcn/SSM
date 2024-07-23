package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName MainApplication
 * @Description TODO
 * @Author hqb
 * @Date 2021/10/25 21:15
 * @Version 1.0
 */

/*
主程序类
这是一个SpringBoot应用
 */
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.atguigu.boot")//这三个注解相当于下面一个注解
@SpringBootApplication(scanBasePackages = "com.atguigu")
public class MainApplication {

    public static void main(String[] args) {

        //1.返回容器里面的组件
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3.从容器中获取组件
//        User user03 = run.getBean("user01", User.class);
//        User user02 = run.getBean("user01", User.class);
//        System.out.println(user03);
//        System.out.println("组件" + (user03 == user02));
//
//        //com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$cc5b46cc@684b31de
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法,springBoot总会检查这个组件是否在容器中
//        //保持组件单实例
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);
//        System.out.println("##############");
//        System.out.println(user);
//        System.out.println("###############");
//        Pet tomcatPet = run.getBean("tomcatPet", Pet.class);
//        System.out.println(user03);
//        System.out.println(tomcatPet);
//
//        //5.获取组件
//        String[] bean1 = run.getBeanNamesForType(User.class);
//        for (String s : bean1){
//            System.out.println(s);
//        }
//        DBHelper bean2 = run.getBean(DBHelper.class);
//        System.out.println(bean2);

//        User user = (User) run.getBean("user01");
//        System.out.println(user);
        boolean tomcatPet = run.containsBean("tomcatPet");
        System.out.println("容器中是否有tomcatPet组件:" + tomcatPet);
        boolean user01 = run.containsBean("user01");
        System.out.println("容器中是否有user01组件:" + user01);
        boolean haha = run.containsBean("haha");
        System.out.println("haha组件" + haha);

    }
}

