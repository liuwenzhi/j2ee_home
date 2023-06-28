package lkhwtk.leetcode100;

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
 * 100. 相同的树
 * 本题思路和101题几乎一致
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //出口1：如果p和q都遍历到了叶子节点的下一层，没有值了，则返回true
        if(p==null&&q==null){
            return true;
        }
        //出口2：如果出口一验证不满足条件，同时出口2满足条件，则两棵树肯定不同
        if(p==null||q==null){
            return false;
        }
        //出口3：经过出口1和出口2的验证，p和q都不为null，则val不等为false
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
