package com.nightstory.mineboot.java.nio;

import java.nio.ByteBuffer;

/**
 * @Author: putao
 * @Date: 2019/6/29
 */
public class Startmain {
    public static void main(String[] args) {
        // buffer channel Selector
        byte a = '1';
        ByteBuffer byteBuf = ByteBuffer.allocate(1024);
        byteBuf.put(a);
        System.out.println(byteBuf.get());
    }
}
