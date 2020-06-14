package com.qing.niu.workstation.web.jdk.concurrency.threadlifecycleobserever;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/13 18:38
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ThreadLifeCycleObserver implements LifeCycleListener{

    private static final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids){
        if (null == ids || ids.isEmpty()){
            return;
        }
        ids.stream().forEach(id -> new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    System.out.println("query for the id " + id);
                    int i = 5 / 0;
                    Thread.sleep(1000);
                    notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                } catch (Exception e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                }
            }
        }).start());
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("The runnable [" + event.getThread().getName() + "] data changed and state is [" + event.getState() + "]");
            if (null != event.getCause()){
                System.out.println("The runnable [" + event.getThread().getName() + "] failed");
                event.getCause().printStackTrace();
            }
        }
    }
}
