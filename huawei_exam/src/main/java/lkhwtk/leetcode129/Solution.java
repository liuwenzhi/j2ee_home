package lkhwtk.leetcode129;

/**
 * 129. 求根节点到叶节点数字之和
 * 核心思路：二叉树的深度优先遍历，即：先序遍历
 * 参考题解：0 ms 教科书级解答
 * 本题用递归的思路实现树的先序遍历，采用栈的方式实现先序遍历很难把每一层树立好，可能做不了。
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        //只有一个节点的情况，这一步可以不加，在dfs方法中做了处理
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return dfs(root, 0);
    }

    /**
     * 核心递归思路：i是一个辅助计算的变量
     */
    private int dfs(TreeNode root, int i) {
        // 递归的出口：子树节点为null，直接返回0，这个出口也需要保留，可能一个只有左子树的节点按照算法会计算右子树的值
        if (root == null) {
            return 0;
        }
        // 中间变量temp，记录从根节点到遍历到的节点的数值
        int temp = i * 10 + root.val;
        // 遍历到叶子节点，直接返回temp，这里是递归的出口
        if (root.left == null && root.right == null) {
            return temp;
        }
        return dfs(root.left, temp) + dfs(root.right, temp);
    }
}
