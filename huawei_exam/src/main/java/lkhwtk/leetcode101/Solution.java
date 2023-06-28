package lkhwtk.leetcode101;

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
 * 101. 对称二叉树
 * 核心思路：通过递归方式判断二叉树是否对称
 * 本题是复旦大学博士面试我的时候考的一个算法题，一家300规模的小公司
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        //空树返回true
        if(root==null){
            return true;
        }
        return dfs(root.left,root.right);
    }

    /**
     * 递归方法
     */
    boolean dfs(TreeNode left, TreeNode right) {
        //递归函数出口：左右子树都为null
        if(left==null&&right==null){
            return true;
        }
        //递归函数出口：左右子树一个为null，一个不为null
        if(left==null||right==null){
            return false;
        }
        //递归函数出口：左右子树不等
        if(left.val!=right.val){
            return false;
        }
        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }
}
