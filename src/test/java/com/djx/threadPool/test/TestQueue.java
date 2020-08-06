package com.djx.threadPool.test;

import com.djx.threadPool.exception.MyQueueSIzeIsZeroException;
import com.djx.threadPool.task.MyQueue;
import com.djx.threadPool.task.Task;

/**
 * 测试队列是否有并发问题
 */
public class TestQueue {

    public static void main(String[] args) throws InterruptedException {

        MyQueue<Task> queue = new MyQueue<Task>();

        for (int i=0;i<10000;i++){
            final String test = ""+i;
            queue.addTail(new Task() {
                public void work() {
                    System.out.println(test);
                }
            });
        }
        System.out.println("添加完成--开始弹出");
        Thread.sleep(1000);

        final MyQueue<Task> queue1 = queue;
        for (int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (queue1.isEmpty()) {
                            System.out.println("没数据了");
                            return;
                        }
                        try {
                            queue1.pop().work();
                        } catch (MyQueueSIzeIsZeroException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
