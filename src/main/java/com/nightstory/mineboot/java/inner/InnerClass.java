package com.nightstory.mineboot.java.inner;

/**
 * @Author: putao
 * @Date: 2019/4/10
 */
public class InnerClass {
    public static void main(String[] args) {
        Bean bean = new Bean();
        Bean.Bean3 bean3 = bean.new Bean3();
        System.out.println(bean3.k++);
    }
}
class Bean{
    class Bean3{
        public int k = 0;
    }
}