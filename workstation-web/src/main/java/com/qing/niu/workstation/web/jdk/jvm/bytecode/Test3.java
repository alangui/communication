package com.qing.niu.workstation.web.jdk.jvm.bytecode;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/9 22:36
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test3 {

    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public static void main(String[] args){
        Test3 test3 = new Test3();

        test3.setX(8);

        in = 20;
    }

    public synchronized void setX(int x){
        this.x = x;
    }

    private void lock(String str){
        synchronized (this){
            System.out.println(str);
        }
    }
}
