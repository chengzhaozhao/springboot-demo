package com.czz.springboot.mybaits.controller;

import com.czz.springboot.mybaits.domain.Department;
import com.czz.springboot.mybaits.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-19 22:25
 */
@RestController
public class DeptController {

    @Autowired
    private DepartmentMapper departmentMapper;


    @GetMapping(value = "/dept/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping(value = "/dept")
    public Department insertDept(Department department){
         departmentMapper.insertDept(department);
         return department;
    }
}
