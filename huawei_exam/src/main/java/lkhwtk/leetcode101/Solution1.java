package lkhwtk.leetcode101;

public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        //空树或者只有一个根节点，直接返回true
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        }
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        //注意递归出口要考虑到最后一层叶子节点，没有左右子树了
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val)
                && isMirror(left.right, right.left)
                && isMirror(left.left, right.right);
    }

}
