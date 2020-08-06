package com.djx.threadPool.test;

import com.djx.threadPool.ThreadPool;
import com.djx.threadPool.task.MyQueue;
import com.djx.threadPool.task.Task;

import java.util.Random;

/**
 * 测试 线程池是否能正常工作
 */
public class TestThreadPool {

    public static void main(String[] args) {

        //创建线程池
        ThreadPool pool = new ThreadPool();
        //获取任务队列
        MyQueue<Task> queue = pool.getQueue();

        for (int i=0;i<100;i++){
            final String test = ""+i;
            queue.addTail(() -> {
                System.out.println(test+"任务开始了");
                try {
                    Thread.sleep(new Random(1).nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(test+"任务结束了");
            });
        }

        pool.start();

        //持续添加任务
        int n = 100;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final String test = ""+n++;
            queue.addTail(() -> {
                System.out.println(test+"任务开始了");
                try {
                    Thread.sleep(new Random(1).nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(test+"任务结束了");
            });
        }

    }
}
