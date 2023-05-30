package com.Iynew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //开启springcloud config服务端注解
public class SCC {
    public static void main(String[] args) {
        SpringApplication.run(SCC.class, args);
    }
}