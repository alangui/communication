package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/28 23:53
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest9 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5000000);

        for (int i = 0; i < 1000000; i++){
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("开始排序：");
        long startTime = System.nanoTime();
        list.stream().sorted().count();
        long endTime = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("排序耗时：" + millis);


    }
}
