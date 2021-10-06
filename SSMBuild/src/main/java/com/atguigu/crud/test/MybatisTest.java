package com.atguigu.crud.test;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 *@ClassName MybatisTest2
 *@Description  测试dao层工作
 *@Author hqb
 *@Date 2021/9/11 14:12
 *@Version 1.0
 *
 * 1.导入SpringTest模块
 * 2.@ContextConfiguration指定Spring配置文件的位置
 */
//单元测试版本
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Test
    public void testCRUD() {
        //1.创建SpringIOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("#################");
        EmployeeMapper bean = context.getBean(EmployeeMapper.class);
        System.out.println(bean);

        System.out.println("###################");
        Employee employee = bean.selectByPrimaryKey(1);
        System.out.println(employee);

    }

    /**
     * 推荐Spring的项目可以使用Spring的单元测试，可以自动注入我们需要的组件
     * 导入SpringTest模块
     */
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;


    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD01(){

        System.out.println(departmentMapper);

        //1.插入几个部门


//        departmentMapper.insertSelective(new Department(1,"开发部"));
//          departmentMapper.insertSelective(new Department(2,"测试部"));


          employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@atguigu,com",2));

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null,uuid,"M", uuid+"@atguigu.com",1));
        }
    }

}