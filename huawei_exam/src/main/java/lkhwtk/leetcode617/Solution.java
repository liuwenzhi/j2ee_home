package lkhwtk.leetcode617;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：617. 合并二叉树
 * 参考思路：动画演示 递归+迭代 617.合并二叉树
 * 本题可以作为合并二叉树的模板
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //如果任何一个树为null，则返回另外一棵树
        if(root1==null||root2==null){
            return root1==null?root2:root1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while(!queue.isEmpty()){
            //while第一次循环合并左右子树根节点，之后每次循循环中，合并r1和r2同时存在相同位置的节点值
            TreeNode r1 = queue.poll();
            TreeNode r2 = queue.poll();
            r1.val = r1.val+r2.val;
            //如果r1和r2的左右子树都不为null，则都进队
            if(r1.left!=null&&r2.left!=null){
                queue.add(r1.left);
                queue.add(r2.left);
            }
            //r1左子树为空，就不需要进队列,相当于直接拷贝一份，r2的左子树，如果左子树包含多层也不用管，相当于直接覆盖
            if(r1.left==null){
                r1.left = r2.left;
            }
            //如果r1和r2的右子树不为null，则都进队
            if(r1.right!=null&&r2.right!=null){
                queue.add(r1.right);
                queue.add(r2.right);
            }
            //r1右子树为null，赋值r2的右子树值
            if(r1.right==null){
                r1.right = r2.right;
            }
        }
        return root1;
    }
}
