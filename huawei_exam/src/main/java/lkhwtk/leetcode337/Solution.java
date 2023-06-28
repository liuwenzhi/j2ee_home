package lkhwtk.leetcode337;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * 本题最开始题目没读明白，实际是实例1迷惑性很大，题目中明确说明：两个直接相连的房子不能在同一天被打劫，
 * 就是爷爷节点被打劫了，就不能打劫父亲节点，可以打劫孙子节点。实例1中，结果是3,3,1，注意第二个3是最左
 * 下角那个3不是根节点的孩子节点
 * 参考题解：官方
 * 算法核心思路：二叉树的遍历
 */
public class Solution {
    /**
     * 集合f代表key为指定node的情况下，在选中这个node的时候，最大盗窃金额
     */
    Map<TreeNode, Integer> f = new HashMap<>();

    /**
     * 集合g代表key为指定node的情况下，不选中这个node的时候，最大盗窃金额
     */
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    /**
     * 递归遍历树，左子树，右子树，根节点处理，实际递归过程
     * 类似于二叉树的后序遍历
     */
    public void dfs(TreeNode node) {
        //二叉树遍历标准的递归方法出口：当遍历到叶子节点下一层的时候，返回
        if (node == null) {
            return;
        }
        //遍历左子树，一层一层一直走到底，后再遍历最底层节点右子树，从低往上一层一层的走，保证子树都把值写进了g和f相关的map，递归之后当前接线能直接调用
        dfs(node.left);
        //遍历右子树
        dfs(node.right);
        //核心思路：在选中当前节点的情况下，包含node节点的最大权值为node.value+node节点左右子树都不选的那个最大值
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        //核心思路：不选择当前节点的情况下，不包含node节点的最大权值为包含或者不包含左子树的最大权值+包含或者不包含右子树的最大权值
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

}
