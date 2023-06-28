package lkhwtk.leetcode111;

/**
 * 注意：树的递归遍历一定要考虑到叶子节点，叶子节点再下一层是null，这个是需要考虑到的内容，
 * 因为实际的树的递归是从叶子界面下边一层null再返回到叶子节点，对于边界处理，null的判断，
 * 一定要注意
 */
public class Solution1 {
    public int minDepth(TreeNode root) {
        System.out.println(root.val);
        if(root == null) {
            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else {
            //Integer.MAX_VALUE设置为-1也可以，重点是上边else if判断
            int left = root.left==null?Integer.MAX_VALUE:minDepth(root.left);
            int right = root.right==null?Integer.MAX_VALUE:minDepth(root.right);
            return Math.min(left, right) + 1;
        }
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        TreeNode root3 = new TreeNode(3);
        TreeNode root9 = new TreeNode(9);
        TreeNode root20 = new TreeNode(20);
        TreeNode root15 = new TreeNode(15);
        TreeNode root7 = new TreeNode(7);
        root3.left = root9;
        root3.right = root20;
        root20.left = root15;
        root20.right = root7;
        solution1.minDepth(root3);
    }
}
