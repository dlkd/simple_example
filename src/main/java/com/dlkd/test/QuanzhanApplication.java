package com.dlkd.test;/**
 * author: 孙维良
 * time:18:39
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName : QuanzhanApplication  //类名
 * @Description :   //描述
 * @Author : 孤 //作者
 * @Date: 2023/11/29  18:39 //日期
 */
@SpringBootApplication
@MapperScan(basePackages = "com.dlkd.test.mapper")
public class QuanzhanApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanzhanApplication.class,args);
    }
}
