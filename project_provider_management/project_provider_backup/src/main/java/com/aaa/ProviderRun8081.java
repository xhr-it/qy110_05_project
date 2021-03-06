package com.aaa;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xhr
 * @date 2020/7/15
 **/
@SpringBootApplication
@MapperScan("com.aaa.mapper")
@EnableTransactionManagement //开启事务
@EnableDiscoveryClient
public class ProviderRun8081 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderRun8081.class,args);
    }
}
