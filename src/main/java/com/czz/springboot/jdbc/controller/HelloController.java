package com.czz.springboot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-19 20:35
 */
@Controller
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select *  from student");
        return maps.get(0);
    }

}
