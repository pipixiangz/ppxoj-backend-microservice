package com.ppx.ppxojbackendgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// mybatisPlus会启动Mysql，所以要排除数据源自动配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class PpxojBackendGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PpxojBackendGatewayApplication.class, args);
    }

}
