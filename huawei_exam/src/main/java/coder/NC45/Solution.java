package coder.NC45;

import java.util.ArrayList;
import java.util.List;

/**
 * NC45 实现二叉树先序，中序和后序遍历
 */
public class Solution {
    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        preOrder(list,root);
        int[][] result = new int[3][list.size()];
        for(int i=0;i<list.size();i++){
            result[0][i] = list.get(i);
        }
        list.clear();
        inOrder(list,root);
        for(int i=0;i<list.size();i++){
            result[1][i] = list.get(i);
        }
        list.clear();
        afterOrder(list,root);
        for(int i=0;i<list.size();i++){
            result[2][i] = list.get(i);
        }
        return result;
    }

    /**
     * 先序遍历
     */
    void preOrder(List<Integer> result, TreeNode root){
        //递归出口，如果节点为null了就结束这一次递归子流程
        if(root == null){
            return;
        }
        //根节点，左子树，右子树
        result.add(root.val);
        preOrder(result,root.left);
        preOrder(result,root.right);
    }

    /**
     * 中序遍历
     */
    void inOrder(List<Integer> result, TreeNode root){
        //递归出口，如果节点为null了就结束这一次递归子流程
        if(root == null){
            return;
        }
        //左子树，根节点，右子树
        inOrder(result,root.left);
        result.add(root.val);
        inOrder(result,root.right);

    }

    /**
     * 后序遍历
     */
    void afterOrder(List<Integer> result, TreeNode root){
        //递归出口，如果节点为null了就结束这一次递归子流程
        if(root == null){
            return;
        }
        //左子树，右子树，根节点
        afterOrder(result,root.left);
        afterOrder(result,root.right);
        result.add(root.val);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        solution.threeOrders(node1);
    }
}
