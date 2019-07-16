package com.nightstory.mineboot.algorithm.datastructure;

import java.util.Stack;

/**
 * @Author: putao
 * @Date: 2018/6/26
 */
public class StackToQuene {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop().intValue();
    }


}
