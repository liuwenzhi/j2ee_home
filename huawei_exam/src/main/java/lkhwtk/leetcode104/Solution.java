package lkhwtk.leetcode104;
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
 * 104. 二叉树的最大深度
 * 注意递归二叉树的常见出口条件：左右子树部分或者全部为null，根节点为null
 * 注意本题在递归上和101题的关联
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        //出口1：到了叶子节点的下一层
        if(root==null){
            return 0;
        }
        //出口2：到达叶子节点
        if(root.left==null&&root.right==null){
            return 1;
        }
        //递归遍历左子树和右子树，得到路径更深的，然后再加上父节点的高度
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
}
