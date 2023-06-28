package lkhwtk.leetcode100;

public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果p和q都遍历到了叶子节点的下一层，没有值了，则返回true
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return (p.val == q.val)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
