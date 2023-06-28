package lkhwtk.leetcode235;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 核心思路：充分利用二叉查找树的特点：左子树的值小于根节点，右子树的值大于根节点
 * 如果两个节点值都小于根节点，说明他们都在根节点的左子树上，我们往左子树上找
 * 如果两个节点值都大于根节点，说明他们都在根节点的右子树上，我们往右子树上找
 * 如果一个节点值大于根节点，一个节点值小于根节点，说明他们他们一个在根节点的左子树上一个在根节点的右子树上，那么根节点就是他们的最近公共祖先节点。
 */

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果p和q一个比root大，一个比root小，或者其中一个是root，那么返回root
        if((p.val-root.val)*(q.val-root.val)<=0){
            return root;
        }
        if(p.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return null;
    }

}
