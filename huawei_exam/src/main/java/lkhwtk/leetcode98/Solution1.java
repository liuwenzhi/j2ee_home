package lkhwtk.leetcode98;

/**
 * 思路参考：中序遍历轻松拿下，🤷‍♀️必须秒懂！
 * 这个思路时空复杂度比本人的好了很多，注意二叉树的遍历过程中，叶子节点的左右子树都会被访问到
 */
public class Solution1 {
    //必须使用long型，使用int会有部分用例跑不完
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        //遍历到叶子节点
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

}
