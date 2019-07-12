package com.nightstory.mineboot.java.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author: putao
 * @Date: 2019/7/3
 */
public class NioMain {


    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ServerSocketChannel channel = ServerSocketChannel.open();
//        channel.bind(new InetSocketAddress(8080));
        channel.socket().bind(new InetSocketAddress(8080));
        SocketChannel accept = channel.accept();
        accept.read(buffer);
        System.out.println();
    }
}
