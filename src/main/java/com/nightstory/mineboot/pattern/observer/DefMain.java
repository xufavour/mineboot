package com.nightstory.mineboot.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: putao
 * @Date: 2019/7/11
 */
public class DefMain {

    public static void main(String[] args) {
        PaymentStatusObservable subject = new PaymentStatusObservable();
        Observer observer = new MyStockObserver();
        subject.addObserver(observer);
        subject.updatePaymentStatus(1);
        subject.updatePaymentStatus(2);

    }
}
class MyStockObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("库存服务收到通知");
    }

}
class PaymentStatusObservable extends Observable {

    public void updatePaymentStatus(int newStatus) {
        // 业务逻辑操作
        System.out.println("更新新的支付状态为：" + newStatus);

        // 通知观察者
        this.setChanged();//需要调用一下这这方法，表示被观察者的状态已发生变更，Observable才会通知观察者
        this.notifyObservers();
    }
}
