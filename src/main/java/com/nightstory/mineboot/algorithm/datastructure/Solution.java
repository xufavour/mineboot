package com.nightstory.mineboot.algorithm.datastructure;

import java.util.ArrayList;

/**
 * @Author: putao
 * @Date: 2018/6/26
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = solution.reConstructBinaryTree(pre,in);
        solution.prePrintTree(node);

    }

    /**
     * 根据前序和中序重建二叉树。
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        int len = pre.length;
        if(len==1){
            root.left=null;
            root.right=null;
            return root;
        }
        //找到中序中的根位置
        int rootval=root.value;
        int i;
        for(i=0;i<len;i++){
            if(rootval==in[i])
                break;
        }
        //创建左子树
        if(i>0){
            int[] pr=new int[i];
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

    /**
     * 遍历二叉树
     * @param node
     */
    public  void prePrintTree(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.value);
        prePrintTree(node.left);
        prePrintTree(node.right);
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> intList=new ArrayList<Integer>();
        ArrayList<TreeNode> treeList=new ArrayList<>();
        if(root==null){
            return intList;
        }
        treeList.add(root);
        for(int i=0;i<treeList.size();i++){
            TreeNode node=  treeList.get(i);
            if(node.left!=null){
                treeList.add(node.left);
            }
            if(node.right!=null){
                treeList.add(node.right);
            }
            intList.add(node.value);
        }
        return intList;
    }


}
