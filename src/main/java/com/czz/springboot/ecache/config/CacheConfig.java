package com.czz.springboot.ecache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-21 14:48
 */
@Configuration
public class CacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
       return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }
}
