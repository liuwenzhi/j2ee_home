package lkhwtk.leetcode156;

/**
 * 156. 上下翻转二叉树(本题不是华为题库中的题，二轮复习的时候看下有没有加进来)
 * 本题题意很不好理解，主要表达的内容是：入参二叉树是一种特殊的二叉树：所有的右节点要么没有，要么肯定有左边的兄弟节点
 * 现在要输出对这棵入参二叉树的翻转，最左下角这个叶子节点翻转到根节点上，然后就是从左下角这个叶子节点的视角，基于原有
 * 的结构去构建一一棵新的二叉树，翻转后原来的右兄弟节点都变成了左边的孩子节点，原来的父节点变成了左孩子节点,题解不太好
 * 理解，画个二叉树，走一走就看明白了。
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode right = null, father = null;
        while(root != null){
            //为了继续遍历，先记录下原来的左子节点防止丢失，备注：root.left这个引用对象后边进行了变更，不会影响left这个对象，下边同理
            TreeNode left = root.left;
            //当前节点的左子节点更新为父节点的右子节点
            root.left = right;
            //记录下当前节点的右子节点
            right = root.right;
            //当前节点的右子节点更新为原父节点
            root.right = father;
            //记录下当前节点作为下一个待遍历节点的父节点（新右子节点）

            father = root;
            root = left;
        }
        //最终root=null,father指向的是最终的根节点
        return father;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right =node5;
        solution.upsideDownBinaryTree(node1);
    }
}
