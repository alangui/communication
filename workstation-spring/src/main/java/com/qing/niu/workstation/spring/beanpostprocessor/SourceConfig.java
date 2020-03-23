package com.qing.niu.workstation.spring.beanpostprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/14 0:58
 * @ProjectName communication
 * @Version 1.0.0
 */
@Configuration
public class SourceConfig {

    @Bean
    public ResourceBundleMessageSource messageSource(){
        System.out.println("init resource bundle message source");
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("locale/messages");
        return messageSource;
    }
}
