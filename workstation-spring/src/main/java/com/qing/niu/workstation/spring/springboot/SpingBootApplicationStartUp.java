package com.qing.niu.workstation.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 16:01
 * @ProjectName communication
 * @Version 1.0.0
 */
@SpringBootApplication
@ComponentScan
public class SpingBootApplicationStartUp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpingBootApplicationStartUp.class);
        springApplication.run(args);
    }
}
