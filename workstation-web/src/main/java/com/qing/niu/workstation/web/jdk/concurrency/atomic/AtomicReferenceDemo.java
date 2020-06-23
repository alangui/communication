package com.qing.niu.workstation.web.jdk.concurrency.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/23 20:56
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<Simple> atomicReference = new AtomicReference<>(new Simple("alan",18));
        System.out.println(atomicReference.get());

        System.out.println(atomicReference.compareAndSet(new Simple("alan",18),new Simple("lea",20)));
    }

    static class Simple{

        private String name;

        private int age;

        public Simple(String name, int age){
            this.name = name;
            this.age = age;
        }

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
}
