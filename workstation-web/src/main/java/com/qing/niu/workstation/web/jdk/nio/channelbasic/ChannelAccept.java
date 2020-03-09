package com.qing.niu.workstation.web.jdk.nio.channelbasic;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/2/23 0:14
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ChannelAccept {

    public static final String GREETING = "Hello I must be going.\r\n";

    public static void main(String[] args) throws Exception{
        int port = 1234;
        ByteBuffer byteBuffer = ByteBuffer.wrap(GREETING.getBytes());
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        while (true){
            System.out.println("Waiting for connections");
            SocketChannel sc = ssc.accept();
            if (sc == null){
                Thread.sleep(2000);
            } else {
                System.out.println("Incoming connection from: " + sc.socket().getRemoteSocketAddress());
                sc.write(byteBuffer);
                sc.close();
            }
        }
    }
}
