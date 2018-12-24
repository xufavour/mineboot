package com.nightstory.mineboot.queue;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: putao
 * @Date: 2018/12/17
 */
public class MainTest {


    public static void main(String[] args) throws Exception {
        String path = "/test/test/bin";
        String log = "/test/test/log.txt";
        File file = new File(path);
        File fileLog = new File(log);
        fileLog.createNewFile();
        FileInputStream f = new FileInputStream(fileLog);
        System.out.println(fileLog.exists());
    }




}
