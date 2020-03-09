package com.qing.niu.workstation.spring.Lifecircle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/8 22:18
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Persion1 implements BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean{

    private String name;

    private String address;

    private String phone;

    private String beanName;

    private BeanFactory beanFactory;

    public Persion1(){
        System.out.println("【构造器】调用Person1的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【注入属性】注入属性address");
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("【注入属性】注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Persion1{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("[BeanNameAware接口]调用BeanNameAware.setBeanName(" + name + ")");
        this.beanName = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory(" + beanFactory + ")");
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】调用DiposibleBean.destory()");
    }

    public void init(){
        System.out.println("person1 init...");
    }

    public void myDestroy(){
        System.out.println("person1 myDestroy...");
    }
}
