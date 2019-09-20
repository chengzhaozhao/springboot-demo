package com.czz.springboot.jdbc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-19 20:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JdbcTest {
    @Autowired
    private DataSource dataSource;

    @Test
    @SneakyThrows
    public void contextLoad() {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        log.info(connection+"");
    }
}
