package com.qing.niu.workstation.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * <p>
 *     SpringBoot启动入口
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/10/9
 */
@Configuration
@SpringBootApplication(exclude = {SpringDataWebAutoConfiguration.class})
@ImportResource({"classpath:spring/application-context.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
