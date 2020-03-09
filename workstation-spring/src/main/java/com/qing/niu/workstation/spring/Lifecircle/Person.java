package com.qing.niu.workstation.spring.Lifecircle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/8 19:29
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Person implements InitializingBean{

    private String name;

    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(){
        System.out.println("person 无参构造方法");
    }

    @PostConstruct
    public void construct(){
        System.out.println("post construct ...");
    }

    public void init(){
        System.out.println("init ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet ...");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
