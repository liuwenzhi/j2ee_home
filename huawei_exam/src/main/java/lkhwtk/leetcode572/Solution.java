package lkhwtk.leetcode572;

/**
 * 572. 另一个树的子树
 * 参考题解：Java 递归版
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //t 为 null 一定都是 true
        if (t == null) return true;
        //这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
