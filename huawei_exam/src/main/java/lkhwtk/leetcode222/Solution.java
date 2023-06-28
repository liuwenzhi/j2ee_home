package lkhwtk.leetcode222;

/**
 * 222. 完全二叉树的节点个数
 */
public class Solution {
    /**
     * 递归思路：当前节点是null，算0，不是null算1，然后和左右子树的节点总数累加返回
     */
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        //当前节点不是null，算1个，返回当前节点个数1类加上当前节点左右子树的节点总数
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    /**
     * 通用计算二叉树层数代码，这个参考备用
     */
    private int countLevel(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(countLevel(root.left),countLevel(root.right)) + 1;
    }

}
