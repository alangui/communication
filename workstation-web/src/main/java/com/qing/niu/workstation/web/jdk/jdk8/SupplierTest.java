package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.function.Supplier;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/16 22:24
 * @ProjectName communication
 * @Version 1.0.0
 */
public class SupplierTest {


    public static void main(String[] args) {

        Supplier<Student> studentSupplier = () -> new Student();
        System.out.println(studentSupplier.get().getName());

        Supplier<Student> supplier = Student::new;
        System.out.println(supplier.get().getName());

    }
}

class Student{

    private String name = "gjk";

    private int age = 20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
