package lkhwtk.Offer_55_I;

/**
 * 二叉树最大深度，直接参考leetcode 104题
 */
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
public class Solution {
    public int maxDepth(TreeNode root) {
        //到了叶子节点的下一层
        if(root==null){
            return 0;
        }
        //到达叶子节点
        if(root.left==null&&root.right==null){
            return 1;
        }
        //递归遍历左子树和右子树，得到路径更深的，然后再加上父节点的高度
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
}
