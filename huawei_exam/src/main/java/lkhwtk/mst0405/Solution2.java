package lkhwtk.mst0405;

/**
 * 基于98题思路实现
 */
public class Solution2 {
    /**
     * 注意：这里选择int类型最小值会有部分用例跑不完
     */
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
