package com.joker.usercenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *配置类，会把这个类注入到ioc容器中
 */
@Configuration // 配置类
@EnableSwagger2 // 开启 swagger2 的自动配置
@Profile({"dev", "test"})   //版本控制访问
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                // 配置接口信息
                .apiInfo(apiInfo())
                .select() // 设置扫描接口
                // 配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.joker.usercenter.controller"))
                .paths(PathSelectors.any()) // 满足条件的路径，该断言总为true
                .build();
    }

    // 基本信息设置
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("伙伴匹配系统") // 标题
                .description("伙伴匹配系统-接口文档") // 描述
                .termsOfServiceUrl("https://www.baidu.com") // 跳转连接
                .version("1.0") // 版本
                .license("Swagger-的使用(详细教程)")
                .licenseUrl("https://blog.csdn.net/xhmico/article/details/125353535")
                .build();
    }
}
