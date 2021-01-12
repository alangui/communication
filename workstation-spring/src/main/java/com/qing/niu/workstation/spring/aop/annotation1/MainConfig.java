package com.qing.niu.workstation.spring.aop.annotation1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>
 * </p>
 *
 * @Author Alan_gui
 * @Date 2021/1/12
 * @ProjectName IntelliJ IDEA
 * @Package com.qing.niu.workstation.spring.aop.annotation1
 * @Version 1.0.0
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfig {

    @Bean
    public Calculate calculate() {
        return new TulingCalculate();
    }

    @Bean
    public TulingLogAspect tulingLogAspect() {
        return new TulingLogAspect();
    }
}
