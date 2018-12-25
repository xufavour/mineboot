package com.nightstory.mineboot.java.socket;

import java.io.*;
import java.net.Socket;

public class SocketMain {
    public static void main(String[] args) throws IOException {
        //为了简单起见，所有的异常都直接往外抛
        String host = "115.239.210.27";  //要连接的服务端IP地址
        int port = 443;   //要连接的服务端对应的监听端口
        //与服务端建立连接
        Socket client = new Socket(host, port);
        //建立连接后就可以往服务端写数据了
        Writer writer = new OutputStreamWriter(client.getOutputStream());
//        writer.write("GET / HTTP/1.1");
        writer.flush();//写完后要记得flush
        //读取来自服务端数据
        Reader reader = new InputStreamReader(client.getInputStream());
        char chars[] = new char[64];
        int len;
        StringBuffer sb = new StringBuffer();
        String temp;
        int index;
        while ((len=reader.read(chars)) != -1) {
            temp = new String(chars, 0, len);
            if ((index = temp.indexOf("eof")) != -1) {
                sb.append(temp.substring(0, index));
                break;
            }
            sb.append(new String(chars, 0, len));
        }
        System.out.println("from server: " + sb);
        writer.close();
        reader.close();
        client.close();
    }
}
