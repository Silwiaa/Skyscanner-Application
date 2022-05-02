package com.backpacktravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SkyscannerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyscannerApplication.class, args);
    }
}