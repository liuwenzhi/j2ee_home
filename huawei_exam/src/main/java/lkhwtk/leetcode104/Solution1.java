package lkhwtk.leetcode104;

/**
 * 推荐题解比我的思路少了一步
 */
public class Solution1 {
    public int maxDepth(TreeNode root) {
        //到达叶子节点下一层
        if(root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
