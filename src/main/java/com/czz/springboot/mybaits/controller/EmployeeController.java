package com.czz.springboot.mybaits.controller;

import com.czz.springboot.mybaits.domain.Employee;
import com.czz.springboot.mybaits.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-20 8:59
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emp")
    public void insertEmp(Employee employee){
        employeeMapper.insertEmp(employee);
    }
}
