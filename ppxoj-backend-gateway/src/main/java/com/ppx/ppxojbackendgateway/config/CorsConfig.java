package com.ppx.ppxojbackendgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.Arrays;

// 处理跨域
@Configuration
// CORS跨域配置类
public class CorsConfig {

    @Bean
    public CorsWebFilter corsFilter() {
        // 创建CORS配置对象
        CorsConfiguration config = new CorsConfiguration();

        // 允许所有HTTP方法，(GET, POST, PUT, DELETE等)
        config.addAllowedMethod("*");

        // 允许跨域请求携带凭证信息(如cookies)
        config.setAllowCredentials(true);

        // TODO: 实际使用时需要将"*"改为线上真实域名和本地开发域名
        // 设置允许的源(域名)模式
        config.setAllowedOriginPatterns(Arrays.asList("*"));

        // 允许所有请求头
        config.addAllowedHeader("*");

        // 创建基于URL的CORS配置源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());

        // 对所有路径应用CORS配置
        source.registerCorsConfiguration("/**", config);

        // 创建并返回CORS过滤器
        return new CorsWebFilter(source);
    }
}