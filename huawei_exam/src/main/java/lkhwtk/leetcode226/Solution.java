package lkhwtk.leetcode226;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * 基于广度优先遍历做一个简单的变换
 * 本题和offer27同个思路
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        //借助队列实现广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            //不用新构建一棵树，直接交换遍历到的节点的左右顺序
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            //这里入队顺序先左后右，或者先右后左都可以
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return root;
    }
}
