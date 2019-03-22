package com.nightstory.mineboot.java.genericity;

/**
 * @author 006
 */
public class Node<T> {
    private T data;
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
