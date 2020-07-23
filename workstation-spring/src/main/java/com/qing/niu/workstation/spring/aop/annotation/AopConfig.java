package com.qing.niu.workstation.spring.aop.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/23 10:23
 * @ProjectName communication
 * @Version 1.0.0
 */
@Configuration
@ComponentScan("com.qing.niu.workstation.spring.aop.annotation")
@EnableAspectJAutoProxy
public class AopConfig {
}
