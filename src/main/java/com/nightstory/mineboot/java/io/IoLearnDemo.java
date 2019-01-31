package com.nightstory.mineboot.java.io;

import java.io.*;

/**
 * @Author: putao
 * @Date: 2019/1/29
 */
public class IoLearnDemo {

    // InputStream 输入流 OutputStream 输出流  相对于系统内存的.
    // 字节流 字符流

    public static void main(String[] args) throws Exception{
        String line = "helloworld!";
        OutputStream out = new FileOutputStream(".//out.txt");
        out.write(line.getBytes());
        InputStream in = new FileInputStream(".//out.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String temp = null;
        while ((temp = reader.readLine()) != null){
            System.out.println(temp + "**" + temp.length());
            System.out.println("**");
        }
//        String str = reader.readLine();
//        System.out.println("readLine 读出后的长度: "+str.length()+"     readLine读的结果: "+str);


    }

}
