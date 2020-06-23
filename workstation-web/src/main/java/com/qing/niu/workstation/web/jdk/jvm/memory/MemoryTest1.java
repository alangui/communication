package com.qing.niu.workstation.web.jdk.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     关于java对象创建的3个步骤
 *     new（分三步，非原子操作，可能重排序）
 *     1、在堆内存中创建出对象的实例
 *     2、为对象的实例成员变量赋初值
 *     3、将对象的引用返回
 *
 *     指针碰撞（前提是堆中的空间通过一个指针进行分割，一侧是已经被占用的空间，另一侧是未被占用的空间）
 *     空闲列表（前提是堆内存空间中已被使用与未被使用的空间是交织在一起的，这时，JVM就需要一个列表来记录哪些空间是可以使用的，
 *     哪些空间是已被使用的，接下来找出可以容纳下新创建对象的且未被使用的空间，在此空间存放该对象，同时还要修改表上的记录）
 *
 *     对象在内存中的布局
 *     1、对象头
 *     2、实例数据
 *     3、对齐填充
 *
 *     引用访问对象的方式
 *     1、使用句柄的方式
 *     2、使用直接指针的方式
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/17 20:20
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MemoryTest1 {

    /**
     * -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        List<MemoryTest1> list = new ArrayList<>();
        for (;;){
            list.add(new MemoryTest1());
        }
    }
}
