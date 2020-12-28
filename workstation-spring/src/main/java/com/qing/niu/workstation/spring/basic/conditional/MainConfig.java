package com.qing.niu.workstation.spring.basic.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
@Configuration
public class MainConfig {

    @Bean
    public TlAspect tlAspect(){
        return new TlAspect();
    }

    @Bean
    @Conditional(value = TlCondition.class)
    public TlLog tlLog() {
        return new TlLog();
    }
}
