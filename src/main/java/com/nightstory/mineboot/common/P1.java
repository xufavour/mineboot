package com.nightstory.mineboot.common;

public class P1 {

    private A a =new A(0);
    private A b =new A(1);

    public void set1() {
        b = b;
    }
    public void set2() {
        b = a;
    }
    public void check() {
        long timeMillis = System.currentTimeMillis();
        if (b.a != 1 && b.a != 0) {
            System.out.println(b.a + "----Error" + " ,time:" + timeMillis + ",a=" + b.a);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String arch = System.getProperty("sun.arch.data.model");
        System.out.println(arch+"-bit");
         P1 v = new P1();
        final Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    v.set1();
                }
            };
        };
        t1.start();
        final Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    v.set2();
                }
            };
        };
        t2.start();
        final Thread t3 = new Thread() {
            public void run() {
                while (true) {
                    v.check();
                }
            };
        };
        t3.start();

    }
}

class A{
    public int a;

    public A(int a) {
        this.a = a;
    }
}