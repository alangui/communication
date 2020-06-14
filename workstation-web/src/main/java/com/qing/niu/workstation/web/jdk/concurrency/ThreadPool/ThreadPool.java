package com.qing.niu.workstation.web.jdk.concurrency.ThreadPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/9 22:02
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ThreadPool extends Thread{

    private int size;

    private final int queueSize;

    private final static int DEFAULT_TASK_QUEUE_SIZE = 2000;

    private static volatile int seq = 0;

    private final static String THREAD_PREFIX = "THREAD-POOL-";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    private final DiscardPolicy discardPolicy;

    private final static  DiscardPolicy DEFAULT_DISCARD_POLICY = () -> {
        throw new DiscardException("Discard thid task");
    };

    private volatile boolean destroy = false;

    private int min;

    private int max;

    private int active;

    public ThreadPool(){
        this(4,8,12,DEFAULT_TASK_QUEUE_SIZE,DEFAULT_DISCARD_POLICY);
    }

    public ThreadPool(int min, int active, int max, int queueSize, DiscardPolicy discardPolicy){
        this.min = min;
        this.active = active;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    private void init(){
        for (int i = 0; i < min; i++){
            createWorkTask();
        }
        this.size = min;
        this.start();
    }

    public void submit(Runnable runnable){
        if (destroy) {
            throw new IllegalStateException("The thread pool already destroy and not allow submit");
        }
        synchronized (TASK_QUEUE){
            if (TASK_QUEUE.size() > queueSize){
                try {
                    discardPolicy.discard();
                } catch (DiscardException e) {
                    System.out.println(e);
                }
                return;
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    @Override
    public void run(){
        while (!destroy){
            System.out.printf("Pool#Min:%d,Active:%d,Max:%d,Current:%d,QueueSize:%d\n",
                    this.min,this.active,this.max,this.size,TASK_QUEUE.size());
            try {
                Thread.sleep(3_000);
                if (TASK_QUEUE.size() > active  && size < active){
                    for (int i = size; i < active; i++){
                        createWorkTask();
                    }
                    System.out.println("The pool incremented to active");
                    size = active;
                } else if (TASK_QUEUE.size() > max && size < max){
                    for (int i = size; i < max; i++){
                        createWorkTask();
                    }
                    System.out.println("The pool incremented to max");
                    size = max;
                }
                if (TASK_QUEUE.isEmpty() && size > active){
                    System.out.println("==========reduce==========");
                    synchronized (THREAD_QUEUE){
                        int releaseSize = size - active;
                        for (Iterator<WorkerTask> it = THREAD_QUEUE.iterator(); it.hasNext();){
                            if (releaseSize <= 0){
                                break;
                            }
                            WorkerTask task = it.next();
                            task.close();
                            task.interrupt();
                            it.remove();
                            releaseSize--;
                        }
                        size = active;
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private void createWorkTask(){
        WorkerTask workerTask = new WorkerTask(GROUP,THREAD_PREFIX + (seq++));
        workerTask.start();
        THREAD_QUEUE.add(workerTask);
    }

    public void shutdown() throws InterruptedException {
        while(!TASK_QUEUE.isEmpty()){
            Thread.sleep(50);
        }

        synchronized (THREAD_QUEUE) {
            int initVal = THREAD_QUEUE.size();
            while (initVal > 0) {
                for (WorkerTask task : THREAD_QUEUE) {
                    if (task.getTaskState() == TaskState.BLOCKED) {
                        task.interrupt();
                        task.close();
                        initVal--;
                    } else {
                        Thread.sleep(10);
                    }
                }
            }
        }
        this.destroy = true;
        System.out.println("The thread pool disposed");
    }

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public boolean isDestroy(){
        return destroy;
    }

    private enum TaskState{
        FREE, RUNNING, BLOCKED, DEAD
    }

    public static class DiscardException extends RuntimeException{

        public DiscardException(String message){
            super(message);
        }
    }

    public interface DiscardPolicy{
        void discard() throws DiscardException;
    }

    private static class WorkerTask extends Thread{
        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup threadGroup, String name){
            super(threadGroup,name);
        }

        @Override
        public void run(){
            OUTER:
            while (this.taskState != TaskState.DEAD){
                Runnable runnable;
                synchronized (TASK_QUEUE){
                    while (TASK_QUEUE.isEmpty()){
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Closed ");
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }

                if (null != runnable){
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

        public void close(){
            this.taskState = TaskState.DEAD;
        }

        public TaskState getTaskState() {
            return taskState;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        IntStream.rangeClosed(0,80).forEach(i -> threadPool.submit(() -> {
            System.out.println("The Runnable be serviced by " + i + " " + Thread.currentThread().getName() + " start.");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
            }
            System.out.println("The Runnable be serviced by " + i + " " + Thread.currentThread().getName() + " finish.");
        }));
//        Thread.sleep(10_000);
//        threadPool.shutdown();
//        threadPool.submit(() -> System.out.println("========"));
    }
}
