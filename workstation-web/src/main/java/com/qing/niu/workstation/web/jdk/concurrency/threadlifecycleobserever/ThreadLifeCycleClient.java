package com.qing.niu.workstation.web.jdk.concurrency.threadlifecycleobserever;

import java.util.Arrays;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/13 18:47
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ThreadLifeCycleClient {

    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2"));
    }
}
