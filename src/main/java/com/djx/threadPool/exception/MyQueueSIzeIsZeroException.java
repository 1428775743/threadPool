package com.djx.threadPool.exception;

public class MyQueueSIzeIsZeroException extends Exception{

    public MyQueueSIzeIsZeroException() {
        super("队列为空异常");
    }
}
