package com.qing.niu.workstation.web.jdk.jdk8;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/14 22:36
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Person {

    private String uaername;

    private int age;

    public Person(String uaername, int age) {
        this.uaername = uaername;
        this.age = age;
    }

    public String getUaername() {
        return uaername;
    }

    public void setUaername(String uaername) {
        this.uaername = uaername;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
