package lkhwtk.leetcode144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树先序遍历的非递归实现
 * 借助栈，基于深度优先遍历方式遍历节点
 * 注意先序遍历和层序遍历的区别
 */
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result,root);
        return result;
    }

    void dfs(List<Integer> result,TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            //注意：子树压栈是先右后左，这样保证出栈的时候是先左后右
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }
}
