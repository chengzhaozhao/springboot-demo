package com.czz.springboot.ecache.controller;

import com.czz.springboot.ecache.service.EmpService;
import com.czz.springboot.mybaits.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-21 12:31
 */
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;



    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return empService.getEmp(id);
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        return empService.updateEmp(employee);
    }
}
