package com.qy.dome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.qy.dome.mapper")
@Slf4j
public class PlatformApplication {

    public static void main(String[] args) {
        log.info("======================platform 服务系统启动=====start=======");
        SpringApplication.run(PlatformApplication.class, args);
        log.info("======================platform 服务系统启动=====end=======");
    }

}
