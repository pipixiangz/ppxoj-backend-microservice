package com.ppx.ppxojbackendjudgeservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.ppx") // 一定要加，要不然不会扫到别的模块的bean
public class PpxojBackendJudgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpxojBackendJudgeServiceApplication.class, args);
	}

}
