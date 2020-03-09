package com.qing.niu.workstation.web.jdk.nio.bufferbasic;

import java.nio.CharBuffer;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/2/18 23:04
 * @ProjectName communication
 * @Version 1.0.0
 */
public class BufferFillDrain {

    private static String[] str = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the monkees",
            "Opening act for the Monkees: JimiHendrix",
            "'Scuse me while I kiss this fly",
            "Help Me! Help Me!",
    };

    private static int index = 0;

    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(100);
        while (fillBuffer(charBuffer)){
            charBuffer.flip();
            drainBuffer(charBuffer);
            charBuffer.clear();
        }
    }

    private static boolean fillBuffer(CharBuffer charBuffer){
        if(index >= str.length){
            return false;
        }
        String s = str[index++];
        for (int i = 0; i < s.length(); i++){
            charBuffer.put(s.charAt(i));
        }
        return true;
    }

    private static void drainBuffer(CharBuffer charBuffer){
        while (charBuffer.hasRemaining()){
            System.out.print(charBuffer.get());
        }
        System.out.println("");
    }
}
