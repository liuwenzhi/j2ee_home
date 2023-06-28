package lkhwtk.leetcode538;

/**
 * 参考题解：官方
 * 官方题解是对个人思路的优化，效率很高。反着中序遍历的顺序来，先遍历右子树，一直到底，做累加，
 * 然后再遍历左子树一直到底。
 */
public class Solution1 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
