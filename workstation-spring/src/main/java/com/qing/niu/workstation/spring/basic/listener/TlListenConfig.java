package com.qing.niu.workstation.spring.basic.listener;

import org.springframework.context.annotation.Bean;
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
public class TlListenConfig {

    @Bean
    public TlApplicationListener tlApplicationListener() {
        return new TlApplicationListener();
    }
}
