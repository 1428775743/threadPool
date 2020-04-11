package com.djx.threadPool.task;

class Node<T> {

    T task;

    Node<T> next;

    Node<T> prev;

    Node(){

    }

    Node(T task){
        this.task = task;
    }
}
