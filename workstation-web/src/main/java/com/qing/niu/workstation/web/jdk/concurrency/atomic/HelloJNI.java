package com.qing.niu.workstation.web.jdk.concurrency.atomic;

/**
 * <p>
 *     javac HelloJNI.java
 *     javah -jni HelloJNI
 *
 *     # :vsplit HelloJNI.c
 *     #include <stdio.h>
 *     #include <jni.h>
 *     #include "HelloJNI.h"
 *
 *     JNIEXPORT void JNICALL java_HelloJNI_hi(JNIEnv *env, jobject o){
 *         printf("hello, i come from c progrmming...\n);
 *     }
 *
 *     ls $JAVA_HOME/include/*
 *     gcc -fPIC -D_REENTRANT -I "$JAVA_HOME/include" -I "$JAVA_HOME/include/linux" -c HelloJNI.c
 *     gcc -shared Hello.o -o libhellojni.so
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/27 15:25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class HelloJNI {

    static {
        System.loadLibrary("hellojni");
    }

    private native void hi();

    public static void main(String[] args) {
        new HelloJNI().hi();
    }
}
