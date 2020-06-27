package com.qing.niu.workstation.web.jdk.jvm.memory;

/**
 * <p>
 *     虚拟机栈溢出
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/24 21:50
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MemoryTest2 {

    /**
     * -Xss100k
     * 1、jvisualVM
     * 2、jconsole
     */
    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            myTest2.test();
        } catch (Throwable e) {
            System.out.println(myTest2.getLength());
            e.printStackTrace();
        }
    }
}

class MyTest2{

    private int length;

    public int getLength(){
        return length;
    }

    public void test(){
        this.length++;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
        }
        test();
    }
}
