package lkhwtk.leetcode337;

/**
 * 参考题解：官方
 * 算法核心思路：类似动态规划，实际是对Solution的优化，用一个数组结构优化f和g两个map
 * 数组是一个一维数组，包括两个元素，包含当前node的最大权值、不包含当前node的最大权值
 */
public class Solution1 {
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        //获取左子树权值数组
        int[] l = dfs(node.left);
        //获取右子树权值数组
        int[] r = dfs(node.right);
        //选择当前节点时候的最大权值，选择左右子树不选中时最大权值
        int selected = node.val + l[1] + r[1];
        //不选择当前节点时候的最大权值，分别找左右子树选中和不选中的最大权值
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        //注意这种一维数组初始化方式
        return new int[]{selected, notSelected};
    }
}
