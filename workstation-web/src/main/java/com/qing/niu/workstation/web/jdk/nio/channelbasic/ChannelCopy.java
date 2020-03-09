package com.qing.niu.workstation.web.jdk.nio.channelbasic;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/2/22 14:00
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ChannelCopy {

    public static void main(String[] args) throws IOException {
        ReadableByteChannel source = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);
//        channelCopy1(source,dest);
        channelCopy2(source,dest);
        source.close();
        dest.close();
    }

    private static void channelCopy1(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 1024);
        while (src.read(byteBuffer) != -1){
            byteBuffer.flip();
            dest.write(byteBuffer);
            byteBuffer.compact();
        }
        byteBuffer.flip();
        while(byteBuffer.hasRemaining()){
            dest.write(byteBuffer);
        }
    }

    private static void channelCopy2(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 1024);
        while(src.read(byteBuffer) != -1){
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                dest.write(byteBuffer);
            }
            byteBuffer.clear();
        }
    }
}
