package lkhwtk.leetcode226;

/**
 * 226. 翻转二叉树
 * 通过递归求解
 */
public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
