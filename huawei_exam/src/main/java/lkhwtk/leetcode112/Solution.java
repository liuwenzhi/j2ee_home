package lkhwtk.leetcode112;

/**
 * 112. 路径总和
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //递归方法出口，如果遍历的节点是null，此时肯定还没取到结果
        if(root==null){
            return false;
        }
        //递归方法出口，遍历到了叶子节点
        if(root.left==null&&root.right==null){
            return root.val == targetSum;
        }
        //递归核心思路：每次用targetNum-当前节点的val
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }

}
