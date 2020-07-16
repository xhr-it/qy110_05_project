package com.aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xhr
 * @date 2020/7/16
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaRun6081 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRun6081.class,args);
    }
}
