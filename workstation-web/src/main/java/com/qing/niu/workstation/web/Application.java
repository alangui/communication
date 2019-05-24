package com.qing.niu.workstation.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>
 *     SpringBoot启动入口
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/10/9
 */
@Slf4j
@EnableScheduling
@Configuration
@SpringBootApplication(exclude = {SpringDataWebAutoConfiguration.class})
@ImportResource({"classpath:spring/application-context.xml"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        log.info("application run...");
        SpringApplication.run(Application.class,args);
        log.info("application had run");
    }
}
