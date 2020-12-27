package com.qing.niu.workstation.spring.swagger;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/8/6
 * @ProjectName IntelliJ IDEA
 * @Version 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * api接口包扫描路径com.qing.niu.workstation.spring.controller.HelloController
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.qing.niu.workstation.spring.controller";

    /**
     * 文档版本
     */
    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger示例demo服务") //设置文档的标题
                .description("swagger示例demo服务 API 接口文档") // 设置文档的描述
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
//                .termsOfServiceUrl("http://www.baidu.com") // 设置文档的License信息->1.3 License information
                .build();
    }
}
