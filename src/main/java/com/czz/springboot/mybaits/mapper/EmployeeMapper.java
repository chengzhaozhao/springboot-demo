package com.czz.springboot.mybaits.mapper;

import com.czz.springboot.mybaits.domain.Employee;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-20 8:46
 */
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);


    public void insertEmp(Employee employee);
}
