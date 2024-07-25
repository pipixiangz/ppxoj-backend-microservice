package com.ppx.ppxojbackendgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PpxojBackendGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxojBackendGatewayApplication.class, args);
    }

}
