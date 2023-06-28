package lkhwtk.leetcode543;

/**
 * 543. 二叉树的直径
 * 参考题解：二叉树的直径 官方
 * 本题作为一个标准求二叉树直径的模板
 */
public class Solution {

    private int ans = 1;//初始化为0也可以
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }
    /**
     * 递归方法统计深度，注意，在深度统计的过程中，最终拿到的ans是一个最长路径的节点个数
     * 实际路径为节点个数-1
     */
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
