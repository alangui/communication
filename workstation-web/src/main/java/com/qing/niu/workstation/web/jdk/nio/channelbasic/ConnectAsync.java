package com.qing.niu.workstation.web.jdk.nio.channelbasic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/2/23 13:22
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ConnectAsync {

    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        System.out.println("initiating connection");
        sc.connect(new InetSocketAddress("localhost",80));
        while (!sc.finishConnect()){
            System.out.println("doing something useless");
        }
        System.out.println("connection established");
        sc.close();
    }
}
