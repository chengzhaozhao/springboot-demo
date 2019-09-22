package com.czz.springboot.cache;

import com.czz.springboot.mybaits.domain.Employee;
import com.czz.springboot.mybaits.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-21 12:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EcacheTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void contextLoads(){
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);

    }
}
