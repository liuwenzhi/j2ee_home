package lkhwtk.leetcode114;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 * 按照个人思路开发，效率不高，但是能达到效果。基于先序遍历找到遍历序列，再生成具体单链表
 */
public class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> treeNodeList = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            treeNodeList.add(node);
            //注意：子树压栈是先右后左，这样保证出栈的时候是先左后右
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }

        }
        root = treeNodeList.get(0);
        TreeNode index = root;
        root.left = null;
        for(int i=1;i<treeNodeList.size();i++){
            TreeNode node = treeNodeList.get(i);
            index.right = node;
            node.left = null;
            index = index.right;
        }
    }
}
