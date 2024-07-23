package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName MyConfig
 * @Description TODO
 * @Author hqb
 * @Date 2021/10/26 16:26
 * @Version 1.0
 */
/*
    1.配置类里面使用@Bean标注在方法上给容器注册组件,默认是单实例的
    2.配置类本身也是组件
    3.proxyBeanMethods,代理bean的方法
        Full(proxyBeanMethods = true)
        Lite(proxyBeanMethods = false)
        解决组件依赖
        最佳实战:
            配置类组件之间无依赖关系用Lite模式加速容器启动过程,减少判断
            配置类组件之间有依赖关系,方法会被调用得到之前的单实例组件,用Full模式
    4.@Import({User.class, DBHelper.class})
      就 给容器中自动创建出这两个类型的组件,默认组件的名字是全类名

      @ImportResource("classpath:bean.xml") 导入spring配置文件使其生效
 */


@Import({User.class, DBHelper.class})
@ImportResource("classpath:bean.xml")
@Configuration(proxyBeanMethods = false)//告诉SpringBoot这是一个配置类 == 配置文件
//@ConditionalOnMissingBean(name = "user01")
@EnableConfigurationProperties(Car.class)
//1. 开启Car配置绑定功能 2.把这个Car这个组件自动注册到容器中
//2.当我们使用第三方类的时候，如果没有把像@Component注解把类注册到容中，就可以使用这种方式把组件注册到容器中
public class MyConfig {
    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     *
     * @return
     */

    @Bean //给容器中添加组件,以方法名作为组件的id.返回类型就是组件的类型.返回的值就是组件在容器中是实例
    public User user01() {
        User user = new User("zhangsan", 18);

        //user组件依赖了Pet组件
        user.setPet(tomcatPet());
        return user;
    }


    @Bean
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}

