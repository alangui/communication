package com.qing.niu.workstation.spring.beanpostprocessor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/13 19:43
 * @ProjectName communication
 * @Version 1.0.0
 */
@Configuration
@PropertySource(value = "classpath:/properties/EmbeddedValueResolver.properties",encoding = "UTF-8")
public class EmbeddedValueResolverConfig implements Serializable{
    private static final long serialVersionUID = 2221715575609124560L;

    @Value("${name}")
    private String name;

    private String age;

    private String sex;

    @Override
    public String toString() {
        return "EmbeddedValueResolverConfig{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
