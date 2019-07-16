package com.nightstory.mineboot.algorithm.offer.part2;

import java.util.ArrayList;

/**
 * @Author: putao
 * @Date: 2019/3/5
 */
public class Unit_two {
    //请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    //输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
    //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    // 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }


    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null)
        {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        int len = pre.length;
        if(len==1){
            root.left=null;
            root.right=null;
            return root;
        }
        //找到中序中的根位置
        int rootval=root.val;
        int i;
        for(i=0;i<len;i++){
            if(rootval==in[i])
                break;
        }
        //创建左子树
        if(i>0){
            int[] pr = new int[i];
            int[] ino=new int[i];
            for(int j=0;j<i;j++){
                pr[j]=pre[j+1];
            }
            for(int j=0;j<i;j++){
                ino[j]=in[j];
            }
            root.left=reConstructBinaryTree(pr,ino);
        }else{
            root.left=null;
        }
        //创建右子树
        if(len-i-1>0){
            int[] pr=new int[len-i-1];
            int[] ino=new int[len-i-1];
            for(int j=i+1;j<len;j++){
                ino[j-i-1]=in[j];
                pr[j-i-1]=pre[j];
            }
            root.right=reConstructBinaryTree(pr,ino);
        }else{
            root.right=null;
        }
        return root;
    }

}

