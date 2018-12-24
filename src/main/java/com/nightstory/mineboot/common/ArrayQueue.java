package com.nightstory.mineboot.common;

public class ArrayQueue {
    private final Object[] queue;  //声明一个数组
    private int head;
    private int tail;

    /**
     * 初始化队列
     * @param capacity 队列长度
     */
    public ArrayQueue(int capacity){
        this.queue = new Object[capacity];
    }

    /**
     * 入队
     * @param o 入队元素
     * @return 入队成功与否
     */
    public boolean put(Object o){
        if(head == (tail+1)%queue.length){
            //说明队满
            return false;
        }
        queue[tail] = o;
        tail = (tail+1)%queue.length;  //tail标记后移一位
        return true;
    }

    /**
     * 返回队首元素，但不出队
     * @return
     */
    public Object peak() {
        if(head==tail){
            //队空
            return null;
        }
        return queue[head];        
    }

    /**
     * 出队
     * @return 出队元素
     */
    public Object pull(){
        if(head==tail){
            return null;
        }
        Object item = queue[head];
        queue[head] = null;
        return item;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return head == tail;
    }

    /**
     * 判断是否为满
     * @return
     */
    public boolean isFull(){
        return head == (tail+1)%queue.length;
    }

    /**
     * 获取队列中的元素个数
     * @return
     */
    public int getsize(){
        if(tail>=head){
            return tail-head;
        }else{
            return (tail+queue.length)-head;
        }
    }    
}