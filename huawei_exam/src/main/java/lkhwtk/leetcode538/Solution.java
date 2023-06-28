package lkhwtk.leetcode538;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 538. 把二叉搜索树转换为累加树
 * 题意：二叉搜索树按照中序遍历序列做成一个累加树
 * 个人思路：中序遍历二叉搜索树，把遍历的结果入栈，完成这一步后从栈中把元素弹出，
 * 计算累加值。空间效率可以，时间效率不高。
 */
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        //定义一个栈，存放树中的节点
        Deque<TreeNode> stack = new LinkedList<>();
        //中序遍历二叉搜索树，将中序遍历的序列压入到stack栈中
        inorder(root,stack);
        int sum = 0;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //这里注意保留下node的值，避免出现sum和node的值重复累加使结果增大
            int temp = node.val;
            node.val += sum;
            sum += temp;
            /*这里可以参考官方思路直接简化：
            sum += node.val;
            node.val = sum;
            * */
        }
        return root;
    }

    /**
     * 二叉树中序遍历递归算法
     */
    private void inorder(TreeNode root, Deque<TreeNode> stack) {
        if (root == null) {
            return;
        }
        inorder(root.left, stack);
        stack.push(root);
        inorder(root.right, stack);
    }

    public static void main(String[] args){
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node4.left = node1;
        node4.right = node6;
        node1.left = node0;
        node1.right = node2;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;
        Solution solution = new Solution();
        solution.convertBST(node4);
    }
}
