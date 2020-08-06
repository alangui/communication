package com.qing.niu.workstation.spring.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/8/6
 * @ProjectName communication
 * @Version 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.qing.niu.workstation.spring.swagger"})
public class SpringBootStart {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootStart.class);
        springApplication.run(args);
    }

}
