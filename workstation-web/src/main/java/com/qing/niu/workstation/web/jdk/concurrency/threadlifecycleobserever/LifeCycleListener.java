package com.qing.niu.workstation.web.jdk.concurrency.threadlifecycleobserever;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/13 18:35
 * @ProjectName communication
 * @Version 1.0.0
 */
public interface LifeCycleListener {

    void onEvent(ObservableRunnable.RunnableEvent event);
}
