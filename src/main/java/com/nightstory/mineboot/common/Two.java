package com.nightstory.mineboot.common;

import com.nightstory.mineboot.bean.One;

/**
 * @Author: putao
 * @Date: 2019/2/20
 */
public class Two extends One{
    static {
        System.out.println("class Two init" );
    }
    protected Two(){
        System.out.println("class Two Constrctor");
    }
    public Two(int a){
        super("test");
        System.out.println("class Two Constrctor a =" + a);
    }
    protected void test(){
        One.staA = 3;
    }
    void defaultMethod(){

    }

    public static void main(String[] args) {
        Two two = new Two(2);
        two.OneMethod();
    }
    @Override
    protected Two protectedprintA(){
        System.out.println("two printA ");
        return new Two(1);
    }

}
