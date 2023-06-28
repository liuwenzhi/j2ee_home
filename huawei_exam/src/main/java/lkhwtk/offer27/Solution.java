package lkhwtk.offer27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 本题同主栈226题，思路和637，二叉树的层序遍历有些类似
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
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
            //顺序先左后右，先右后左都可以
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
