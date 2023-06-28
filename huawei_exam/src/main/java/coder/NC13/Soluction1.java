package coder.NC13;

/*
* 使用简单递归方式实现二叉树深度遍历
*/
public class Soluction1 {


    public int maxDepth (TreeNode root) {
        // write code here
        if(root == null)return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public int maxDepth1 (TreeNode root) {
        if(root==null)return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int res = Math.max(leftDepth,rightDepth);
        return res+1;
    }
}
