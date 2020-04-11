package com.djx.threadPool;

import com.djx.threadPool.task.MyQueue;
import com.djx.threadPool.task.Task;
import com.djx.threadPool.thread.MyThread;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private List<MyThread> threads;

    private MyQueue<Task> queue = new MyQueue<>();

    private int size;

    private final int maxSize = 4;

    public ThreadPool(){
        createThreadList(maxSize);
    }

    public ThreadPool(int size){
        this.size = size;
        createThreadList(size);
    }

    private void createThreadList(int size) {

        threads = new ArrayList<MyThread>(size);
        for (int i=0;i<size;i++){
            threads.add(new MyThread(i,queue));
        }
    }

    /**
     * 获取任务队列
     */
    public MyQueue<Task> getQueue() {
        return queue;
    }

    public void start(){

        threads.forEach(thread->{
            thread.start();
        });
    }
}
