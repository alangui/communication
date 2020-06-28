package com.qing.niu.workstation.web.jdk.jvm.memory;

/**
 * <p>
 *     1、jps  => PID
 *     2、jmap -clstats PID
 *     3、jmap -heap PID
 *     4、jstat -gc PID
 *     5、jcmd(1.7) PID VM.flag 查看JCM启动参数
 *     6、jcmd -l
 *     7、jcmd PID help 列出当前运行的java进程可以执行的操作
 *     8、jcmd PID help JFR.dump 查看具体命令的选项
 *     9、jcmd PID PerfCounter.print 查看JVM性能相关的参数
 *     10、jcmd PID VM.uptime 查看JVM运行时间
 *     11、jcmd PID GC.class_histogram 查看系统中类的统计信息
 *     12、jcmd PID Thread.print 查看线程的堆栈信息
 *     13、jcmd PID GC.heap_dump 导出heap dump文件 ，并适合用jvisualVM查看
 *     14、jcmd PID VM.system_properties 查看JVM的属性信息
 *     15、jcmd PID VM.version 查看目标JVM进程的版本信息
 *     16、jcmd PID VM.command_line 查看jvm启动的命令行信息
 *     jstack PID 查看JVM堆栈信息
 *     jmc java mission control
 *     JFR 飞行记录器
 *     jhat
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/26 16:35
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MemoryTest4 {

    /**
     * -XX:MaxMetaspaceSize=200m
     */
    public static void main(String[] args) {
        for (;;){
            System.out.println("hello world");
        }
    }
}
