package lkhwtk.leetcode145;

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
 * 题目：二叉树的后序遍历
 * 核心思路：和94题、144题类似，采用教科书的思路：左->右->根
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result,root);
        return result;
    }

    void dfs(List<Integer> result,TreeNode root){
        //递归出口，如果节点为null了就结束这一次递归子流程
        if(root == null){
            return;
        }
        dfs(result,root.left);
        dfs(result,root.right);
        result.add(root.val);
    }
}
