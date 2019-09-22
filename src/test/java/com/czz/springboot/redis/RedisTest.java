package com.czz.springboot.redis;

import com.czz.springboot.mybaits.domain.Employee;
import com.czz.springboot.mybaits.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-21 15:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RedisTemplate<String,Object> myRedisTemplate;

    @Test
    public void contextLoads3(){
        Employee employee = employeeMapper.getEmpById(1);
//        System.out.println(employee);
        // 默认的jdk 序列化机制
//        myRedisTemplate.opsForValue().set("emp-01",employee.toString());
        // 将对象转为json
        myRedisTemplate.opsForValue().set("emp-01",employee);
        Employee employee2 = (Employee) myRedisTemplate.opsForValue().get("emp-01");
        System.out.println(employee2);
    }

    /**
     * 字符串  stringRedisTemplate.opsForValue()
     * List  stringRedisTemplate.opsForList()
     * Set  stringRedisTemplate.opsForSet()
     * hash stringRedisTemplate.opsForHash()
     * zset stringRedisTemplate.opsForZSet()
     */
    @Test
    public void contextLoads(){
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);

        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");

    }

    /**
     * 测试保存对象
     */
    @Test
    public void contextLoads2(){


    }
}
