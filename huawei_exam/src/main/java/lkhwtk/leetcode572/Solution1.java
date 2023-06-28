package lkhwtk.leetcode572;

/**
 * 参考题解：一篇文章带你吃透对称性递归(思路分析+解题模板+案例解读)
 * 根据里边的C++模板改的java版代码实现
 * 一篇文章带你吃透对称性递归(思路分析+解题模板+案例解读) 这个题解说明不错，大部分二叉树的算法都可以通过里边的递归模板来做
 */
public class Solution1 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null || t==null)
            return false;
        if (isSameTree(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
