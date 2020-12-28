package com.qing.niu.workstation.spring.Lifecircle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/8 19:35
 * @ProjectName communication
 * @Version 1.0.0
 */
@Configuration
@ComponentScan(basePackages = {"com.qing.niu.workstation.spring.Lifecircle"})
public class MainConfig {

    @Bean(initMethod = "init")
    public Person person(){
        return new Person();
    }

//    @Bean(initMethod = "init",destroyMethod = "myDestroy")
    public Persion1 persion1(){
        Persion1 persion1 = new Persion1();
        persion1.setName("张三");
        persion1.setAddress("上海");
        persion1.setPhone("15600000000");
        return persion1;
    }
}
