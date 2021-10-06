package com.atguigu.crud.service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@ClassName EmployeeService
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/4 19:13
 *@Version 1.0
 */

@Service
public class EmployeeService{

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAll() {

        /**
         * 查询所有员工(分页查询)
         */
        return employeeMapper.selectByExampleWithDept(null);

    }
}

