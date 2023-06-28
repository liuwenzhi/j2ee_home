package lkhwtk.leetcode450;

/**
 * 450. 删除二叉搜索树中的节点
 * 参考题解：官方
 * 基础知识点：二叉搜索树的左子树上节点值都比根节点小，右子树上节点值都比根节点大
 */
public class Solution {
    /**
     * 获取当前节点的后继节点：
     * 根据二叉搜索树的性质：二叉搜索树的中序遍历的序列是递增排序的序列。中序遍历的遍历次序：Left -> Node -> Right。
     * 当前节点的后继节点方式为：获取右子树节点，然后一直遍历该节点的左子树
     * 直到左子树为null，这个时候找到的这个节点就是当前节点的后继节点
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }

    /**
     * 获取当前节点的前驱节点：
     * 获取当前节点的前驱节点，和后继节点相反，找到当前节点的左子树，然后一直遍历左子树的右子树，
     * 一直到右子树为null，这个时候最后这个节点，就是当前节点的前驱节点
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null){
            root = root.right;
        }
        return root.val;
    }

    /**
     * 删除节点，核心思路：先定位要删除的节点的位置，通过根节点，一层一层往下找，根据删除节点值比根节点大或者小王右子树或者左子树上找，
     * 直到等于key的节点，然后根据节点是否包含左右子树来获取前驱或者后继节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        //删除的元素在右子树
        if(key > root.val){
            //deleteNode返回调整好的右子树
            root.right = deleteNode(root.right, key);
        }else if (key < root.val){
            //删除左子树，返回调整好的左子树
            root.left = deleteNode(root.left, key);
        }else{
            //找到当前要删除节点的情况
            if (root.left == null && root.right == null){
                //如果要删除的节点是一个叶子节点，直接干掉
                root = null;
            }else if (root.right != null) {
                //当前节点非叶子节点，有一个右子树（此时可能有左子树也可能没有，有右子树就按右子树来，找后继节点，左右都可以），
                //获取当前节点的后继节点值赋值给当前节点，然后去右子树删除这个后继节点，一层一层递归往下走，直到全部调整完成
                root.val = successor(root);
                //后继节点在root节点的右子树最靠左边的位置，后继节点已经被放到root上了，就需要到root的右子树去删除这个后继节点了
                root.right = deleteNode(root.right, root.val);
            }else {
                //当前节点非叶子节点，没有右子树但是有一个左子树，获取前驱节点值赋值给当前节点，然后去左子树去删除前驱节点
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        Solution solution = new Solution();
        solution.deleteNode(root,3);
    }

}
