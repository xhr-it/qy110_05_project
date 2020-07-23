package com.aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xhr
 * @date 2020/7/15
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.aaa"})
public class ConsumerRun7081 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRun7081.class,args);
    }
}
