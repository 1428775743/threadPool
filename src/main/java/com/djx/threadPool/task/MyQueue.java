package com.djx.threadPool.task;

import com.djx.threadPool.exception.MyQueueSIzeIsZeroException;

public class MyQueue<T> {

    /**
     * 头节点
     */
    private Node<T> head;

     /**
     * 尾部节点
     */
    private Node<T> tail;

    /**
     * 大小长度
     */
    private int size;

    /**
     * 添加头部
     */
    public synchronized void addHead(T task){

        Node<T> taskNode = new Node(task);
        //node的next指向原head
        taskNode.next = head;
        if (head != null){
            head.prev = taskNode;
        }
        head = taskNode;
        //如果此时大小为0则头就是尾
        if (size == 0){
            tail = head;
        }
        size++;
        this.notify();
    }

    /**
     * 添加尾部
     */
    public synchronized void addTail(T task){

        Node<T> taskNode = new Node(task);
        //node的prev指向原tail
        taskNode.prev = tail;
        if(tail != null){
            tail.next = taskNode;
        }
        tail = taskNode;
        //如果此时大小为0则头就是尾
        if (size == 0){
            head = tail;
        }
        size++;
        this.notify();
    }

    /**
     * 弹出头部节点
     * @return 任务
     */
    public synchronized T pop() throws MyQueueSIzeIsZeroException {

        if (isEmpty()){
            throw new MyQueueSIzeIsZeroException();
        }

        Node<T> taskNode = head;
        if (head.next != null) {
            head = head.next;
            head.prev = null;
        }
        taskNode.next = null;
        size--;
        return taskNode.task;
    }


    public synchronized boolean isEmpty(){
        return size == 0;
    }
}
