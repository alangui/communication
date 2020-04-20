package com.qing.niu.workstation.web.jdk.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/13 20:57
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test4 {

    public void test(){
        try {
            InputStream is = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
    }
}
