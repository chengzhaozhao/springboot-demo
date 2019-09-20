package com.czz.springboot.mybaits.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-20 8:36
 */
@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    /**
     * 自定义mybatis 配置规则
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
      return new ConfigurationCustomizer(){
            @Override
            public void customize(Configuration configuration) {
                // 开启驼峰 适配 数据库中的 column_column
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
