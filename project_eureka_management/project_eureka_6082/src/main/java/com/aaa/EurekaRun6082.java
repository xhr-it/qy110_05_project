package com.aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author xhr
 * @date 2020/7/27
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaRun6082 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRun6082.class,args);
    }
}
