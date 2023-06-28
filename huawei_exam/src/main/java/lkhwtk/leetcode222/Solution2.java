package lkhwtk.leetcode222;

/**
 * 参考题解：常规解法和击败100%的Java解法
 */
public class Solution2 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            //1<<left 相当于2的left次幂
            return countNodes(root.right) + (1<<left);
        }else{
            //1<<right 相当于2的right次幂
            return countNodes(root.left) + (1<<right);
        }
    }

    /**
     * 计算完全二叉树的层数，注意完全二叉树的特点：它是一棵空树或者它的叶子节点只出在最后两层，
     * 若最后一层不满则叶子节点只在最左侧。相对于Solution，这里不用使用递归直接能搞定，就往最左边子树上找
     */
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }

}
