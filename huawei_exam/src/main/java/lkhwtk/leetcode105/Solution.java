package lkhwtk.leetcode105;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 思路参考：从前序与中序遍历序列构造二叉树 官方
 * 本题的核心思路为：结合前序遍历和中序遍历的特点，确认前序遍历和中序遍历中根节点坐标，左子树坐标范围，右子树坐标范围
 * 然后递归的构建出最终的树
 */
public class Solution {
    /**
     * indexMap保存中序遍历序列
     */
    private Map<Integer, Integer> indexMap;

    /**
     * 通过递归方式构建二叉树
     */
    public TreeNode myBuildTree(int[] preorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        //首先定义递归出口条件
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点，获取根节点的位置
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点位置
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //通过中序遍历序列得到左子树中的节点数目，这里就是直接减，不用算上root节点
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点，将中序遍历的节点放到index索引map中
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, n - 1, 0, n - 1);
    }
}
