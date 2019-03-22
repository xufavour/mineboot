package com.nightstory.mineboot.java.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: putao
 * @Date: 2019/3/11
 */
public class NioLearnDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
      Thread th = new Thread(new Runnable() {
          @Override
          public void run() {
              RandomAccessFile aFile = null;
              try {
                  aFile = new RandomAccessFile("/Users/006/Desktop/test.txt", "rw");

              FileChannel channel = aFile.getChannel();
              ByteBuffer buf = ByteBuffer.allocate(5);
              int bytesRead = channel.read(buf);
              while (bytesRead != -1) {
                  System.out.println("Read " + bytesRead);
                  buf.flip();//写模式转成读模式
                  while (buf.hasRemaining()) {
                      System.out.print((char) buf.get());
                  }
                  System.out.println();
                  buf.clear();
                  bytesRead = channel.read(buf);
              }
              aFile.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      });
        th.start();
        while (th.isAlive()){
            System.out.println(th.getState());
        }
    }
}
