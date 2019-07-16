package com.nightstory.mineboot.algorithm.offer.part2;

/**
 * @Author: putao
 * @Date: 2019/3/5
 */
public class Unit_four {
    //输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    public int NumberOf1(int n) {
//        int count = 0;
//        for(int i = 0; i < 32; i++){
//            if((n >>> i & 1) == 1)
//                ++count;
//        }
//        return count;
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    public double Power(double base, int exponent) {
        double  result=1;
        for(int i=0;i<Math.abs(exponent);i++){
            result*=base;
        }
        if(exponent<0){
            result=1/result;
        }
        return result;
    }
    public double Power2(double base, int exponent) {

        if(exponent==0 && base != 0)
            return 1;
        if(exponent==1)
            return base;
        if(base == 0 && exponent <= 0){
            throw new RuntimeException();
        }
        if(base ==0 && exponent>0){
            return 0;
        }
        int n= exponent;
        if(exponent<0){
            n = -exponent;
        }
        double  result=Power(base,n>>1);
        result*=result;
        if((n&1)==1)
            result*=base;
        if(exponent<0)
            result=1/result;
        return result;
    }
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。

    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        int[] temp = new int[array.length];
        int count = 0;
        int old = 0;
        for(int i =0; i < array.length; i++){
            if(array[i]%2 == 0){
                temp[count++] = array[i];
            }else {
                array[old++] = array[i];
            }
        }
        for(int i = 0; i< count; i++){
            array[old++] = temp[i];
        }
    }
    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k < 1){
            return null;
        }
        ListNode pre=head;
        ListNode last=head;
        for(int i=1;i<k;i++){
            if(pre.next!=null){
                pre=pre.next;
            }else{
                return null;
            }
        }
        while(pre.next!=null){
            pre = pre.next;
            last=last.next;
        }
        return last;
    }
    //输入一个链表，反转链表后，输出新链表的表头。
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                    mergeHead = current = list1;
                }else{
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead == null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;

    }
}
