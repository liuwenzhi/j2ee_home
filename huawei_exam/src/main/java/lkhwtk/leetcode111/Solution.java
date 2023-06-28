package lkhwtk.leetcode111;
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
 * 本题和104题解法一致，104求最大深度，本题求最小深度
 * 这里需要考虑一个特殊情况：比如一棵二叉树，没有左子树，
 * 只有右子树，则最小深度是右子树的深度，不是0，算法中再统计左右子树的时候，特意加了不为null的设计
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else {
            int min_depth = Integer.MAX_VALUE;
            if(root.left!=null){
                min_depth = Math.min(minDepth(root.left),min_depth);
            }
            if(root.right!=null){
                min_depth = Math.min(minDepth(root.right),min_depth);
            }
            //统计出左右子树最小路径，再加一个当前节点作为路径
            return min_depth+1;
        }
    }
}
