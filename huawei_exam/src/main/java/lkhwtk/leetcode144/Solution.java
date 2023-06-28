package lkhwtk.leetcode144;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
   }
}

/**
 * 题目：144.二叉树的先序遍历，二叉树前序遍历
 * 核心思路：和94题类似，按照教科书中的思路：根->左->右
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result,root);
        return result;
    }

    void dfs(List<Integer> result,TreeNode root){
        //递归的出口：子树节点为null
        if(root == null){
            return;
        }
        result.add(root.val);
        dfs(result,root.left);
        dfs(result,root.right);
    }
}
