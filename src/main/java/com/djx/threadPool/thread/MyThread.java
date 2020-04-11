package com.djx.threadPool.thread;

import com.djx.threadPool.constant.ThreadStatus;
import com.djx.threadPool.exception.MyQueueSIzeIsZeroException;
import com.djx.threadPool.task.MyQueue;
import com.djx.threadPool.task.Task;

public class MyThread extends Thread{

    private int id;

    private ThreadStatus status;

    private MyQueue<Task> taskQueue;

    private boolean notice = true;

    public MyThread(int id,MyQueue taskQueue) {
        this.id = id;
        this.status = ThreadStatus.READY;
        this.taskQueue = taskQueue;
    }

    public void setNotice(boolean notice){
        this.notice = notice;
    }

    @Override
    public void run() {
        this.status = ThreadStatus.START;
        while (notice){

            if (taskQueue.isEmpty()) {

                synchronized (taskQueue) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        continue;
                    }
                }
            }
            System.out.println("id+"+id+"开始执行任务");
            try {
                taskQueue.pop().work();
            } catch (MyQueueSIzeIsZeroException e) {
                e.printStackTrace();
            }
            System.out.println("id+"+id+"结束执行任务");
        }
        this.status = ThreadStatus.END;
    }
}
