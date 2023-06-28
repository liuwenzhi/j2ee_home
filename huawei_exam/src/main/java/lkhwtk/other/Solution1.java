package lkhwtk.other;

import lkhwtk.leetcode747.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 单独备份下广度优先遍历（层序遍历）算法
 * 备注：深度优先遍历可参考144题Solution1
 */
public class Solution1 {
    public void bfs(List<Integer> result,TreeNode root){
        if(root==null){
            return ;
        }
        //借助队列实现广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            //借助队列先进先出原则，先让左节点入队，后让右节点入队
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        List<Integer> result = new ArrayList<>();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node2.left = node7;
        node2.right = node8;
        solution1.bfs(result,node1);
        result.forEach(i->{
            System.out.print(i+" ");
        });
    }
}
