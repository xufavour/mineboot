package com.nightstory.mineboot.java.concurrent;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: putao
 * @Date: 2019/3/15
 * Thread
 */
public class ThreadBootstart {



    public static void main(String[] args) {
        /**
         * New
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
        Thread thread = new Thread(new CustomRunnable(cyclicBarrier));
        /**
         * RUNNABLE java中将操作系统下线程的就绪状态，运行状态统一成了RUNNABLE状态:这个状态(处于就绪状态)不一定在占用cpu
         */
        thread.start();
//        thread.interrupt();
//        while (thread.getState().compareTo(Thread.State.TERMINATED) != 0){
//            System.out.println(thread.getState());
//        }
        System.out.println("main end");


    }
    /**
     * threadPoolExecutor.shutdown(): 调用后拒绝加入任务,等待正在运行的线程完成,等待队列中任务执行完成
     * threadPoolExecutor.shutdownNow():调用后拒绝加入任务,返回队列中等待的任务列表,尝试中断结束正在运行的线程,(存在当其中有线程响应中断后仍在执行，则是代码逻辑问题)
     *
     * shutdown():等待那些已经开始的任务执行完毕，等待任务队列中尚未开始的任务执行完毕。
     shutdownNow():尝试取消已经开始的任务（中断这些任务），返回任务队列中尚未开始的任务。
     shutdownNow只返回任务队列中尚未开始的任务列表，但是想要记录那些已经开始但被取消的任务，可以使用条件检查：线程池的状态处于关闭中且任务的状态为已中断（当然前提是任务要保持中断状态）。
     之前对中断有点误解，以为线程调用interrupt()后，其中断状态一直未true,其实不然：线程被中断后，其中断状态变为true,但是如果线程响应了中断（阻塞方法响应了中断）或者线程执行完毕，线程的中断状态会变为false

     */
    /**
     * interrupt方法用于标记 中断线程的, flag 线程自检时，注意：不能中断竞争锁失败,io流时阻塞
     * 调用了A线程的interrupt方法,如果A已经处于阻塞状态,则抛出InterruptedException,若未处于阻塞状态时，当线程A调用wait sleep,join等阻塞时会直接抛出异常并清除中断标志.
     * 注意:interrupt()并不会终止处于“运行状态”的线程！它会将线程的中断标记设为true.
     *
     * 中断标记为true时,线程会处于一种检测响应中断状态,当线程处于非运行状态时就会立即响应中断。
     * 响应中断后走catch (InterruptedException e) {}内部的逻辑,如果catch内执行结束后，线程还未结束，则会继续执行下去。
     *
     *
     * 中断是通过调用Thread.interrupt()方法来做的. 这个方法通过修改了被调用线程的中断状态来告知那个线程, 说它被中断了. 对于非阻塞中的线程, 只是改变了中断状态, 即Thread.isInterrupted()将返回true; 对于可取消的阻塞状态中的线程, 比如等待在这些函数上的线程, Thread.sleep(), Object.wait(), Thread.join(), 这个线程收到中断信号后, 会抛出InterruptedException, 同时会把中断状态置回为true.但调用Thread.interrupted()会对中断状态进行复位。
     *
     * interrupted() 和 isInterrupted()都能够用于检测对象的“中断标记”。区别是，interrupted()除了返回中断标记之外，它还会清除中断标记(即将中断标记设为false)；而isInterrupted()仅仅返回中断标记。
     * Thread.interrupted() 是静态方法，因此不能在特定的线程上使用
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

class CustomRunnable implements Runnable{
    CyclicBarrier cyclicBarrier;
    public CustomRunnable( CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "start" + cyclicBarrier.getNumberWaiting() + ","  + cyclicBarrier.getParties());
        /**
         * LockSupport.park(),object.wait()(不指定时间);进入WAITING
         * Thread.sleep(time) object.wait(time)进入TIMED_WAITING
         * 竞争锁失败,io流阻塞时进入BLOCKED.
         */


        System.out.println("thread over." + Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().getName() + "end");

    }
}

/**
 * CountDownLatch countDownLatch = new CountDownLatch(n); : 调用countDownLatch.await()线程进入阻塞直到 countDownLatch.countDown() 自减到0，阻塞中可以被中断,不能重复使用。
 *
 *CyclicBarrier cyclicBarrier = new CyclicBarrier(n); 栅栏,调用 cyclicBarrier.await()线程到达栅栏,只有当所有(n个)的线程到达栅栏时才会停止阻塞。可以重置。
 *
 * Semaphore信号量，Semaphore可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。可以用来控速。
 *
 * Exchanger<String>
 *当一个线程到达exchange调用点时，如果它的伙伴线程此前已经调用了此方法，那么它的伙伴会被调度唤醒并与之进行对象交换，然后各自返回。如果它的伙伴还没到达交换点，那么当前线程将会被挂起，直至伙伴线程到达——完成交换正常返回；或者当前线程被中断——抛出中断异常；又或者是等候超时——抛出超时异常。
 */

/**
 * 带有返回值的,配合Future使用
 * @param <T>
 */
class CustomCallable<T> implements Callable<T>{

    @Override
    public T call() throws Exception {
        return null;
    }
}
