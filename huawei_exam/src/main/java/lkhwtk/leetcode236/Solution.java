package lkhwtk.leetcode236;

/**
 * 236. 二叉树的最近公共祖先
 * 参考题解：236. 二叉树的最近公共祖先（DFS ，清晰图解）
 * 注意一个核心的性质：如果root是left和right的公共祖先，在left和right本身不是root的情况下，那么一定有从root的左子树能找到left，右子树能找到right
 * 这里left可能是p，也可能是q
 * 算法设计核心点：
 * p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
 * p=root ，且 q 在 root 的左或右子树中；
 * q=root ，且 p 在 root 的左或右子树中；
 * 这个递归算法结合本题解的动图来看就好理解很多
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null){
            return null; // 1.
        }
        if(left == null){
            return right; // 3.
        }
        if(right == null){
            return left; // 4.
        }
        // 2. if(left != null and right != null)
        return root;
    }
}
