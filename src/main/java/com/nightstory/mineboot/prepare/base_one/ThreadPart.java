package com.nightstory.mineboot.prepare.base_one;

/**
 * @Author: putao
 * @Date: 2019/2/18
 */
public class ThreadPart {


    public static void main(String[] args) {
        interruptOneThread();
    }


















    /**
     * interrupt方法用于标记 中断线程的, flag
     * 调用了A线程的interrupt方法,如果A已经处于阻塞状态,则抛出InterruptedException,若未处于阻塞状态时，当线程A调用wait sleep,join等阻塞时会直接抛出异常并清除中断标志.
     * 注意:interrupt()并不会终止处于“运行状态”的线程！它会将线程的中断标记设为true.
     *
     * 中断标记为true时,线程会处于一种检测响应中断状态,当线程处于非运行状态时就会立即响应中断。
     * 响应中断后走catch (InterruptedException e) {}内部的逻辑,如果catch内执行结束后，线程还未结束，则会继续执行下去。
     *
     * interrupted() 和 isInterrupted()都能够用于检测对象的“中断标记”。区别是，interrupted()除了返回中断标记之外，它还会清除中断标记(即将中断标记设为false)；而isInterrupted()仅仅返回中断标记。
     * @throws InterruptedException
     */
    private static void interruptOneThread()  {
        Thread threadA = new Thread(() -> {
            int i = 2;
            while (i > 0){
                System.out.println("test");
            }
            System.out.println();
            System.out.println("start");
            try {
                System.out.println(Thread.interrupted());
                System.out.println("start sleep");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
            System.out.println("threadA thread end");
        });
        threadA.start();
        System.out.println(threadA.getState());
        System.out.println("start interrupt");
        threadA.interrupt();
        threadA.stop();
        System.out.println("main end");
    }
}
