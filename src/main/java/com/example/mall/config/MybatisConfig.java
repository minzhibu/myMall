package com.example.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.mall.mbg.mapper")
public class MybatisConfig {

}
