package com.briup.apps.tb_app01.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.apps.tb_app01.mapper")
public class MybatisConfig {

}
