package com.qing.niu.workstation.web.jdk.concurrency;

/**
 * <p>
 *     nohup.out java -cp . ExitCapture &
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/8 21:50
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ExitCapture {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            System.out.println("the application will be exit.");
            notifyAndRelease();
        }));

        int i = 0;
        while (true){
            try {
                Thread.sleep(1_0000);
                System.out.println("I am working");
            } catch (InterruptedException e) {
            }
            i++;
            if (i > 20){
                throw new RuntimeException("Error");
            }
        }
    }

    public static void notifyAndRelease(){
        System.out.println("notify to the admin");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
        }
        System.out.println("will release resource: such as socket file connection");
        System.out.println("done");
    }
}
