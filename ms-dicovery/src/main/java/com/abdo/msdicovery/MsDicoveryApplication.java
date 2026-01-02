package com.abdo.msdicovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsDicoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsDicoveryApplication.class, args);
    }

}
