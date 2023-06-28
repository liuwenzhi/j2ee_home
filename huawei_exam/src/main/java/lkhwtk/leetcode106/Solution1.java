package lkhwtk.leetcode106;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于Solution1，优化递归方法，去掉不必要的参数
 */
public class Solution1 {
    /**
     * 存放中序遍历序列
     */
    private Map<Integer, Integer> indexMap;

    /**
     * 通过递归方式构建二叉树
     * @param postorder  后序遍历序列数组
     * @param postorder_left 后序遍历左端开始位置(包含左端)
     * @param postorder_right 后序遍历右端结束位置(包含右端)
     * @param inorder_left 中序遍历左端开始位置，包含左端
     */
    public TreeNode myBuildTree(int[] postorder, int postorder_left, int postorder_right, int inorder_left) {
        //首先定义递归出口条件
        if (postorder_left > postorder_right) {
            return null;
        }
        //后序遍历最后一个节点是根节点
        int postorder_root = postorder_right;
        //在中序遍历中定位根节点的位置值
        int inorder_root = indexMap.get(postorder[postorder_root]);

        //根据后序遍历的根节点的值建立根节点节点
        TreeNode root = new TreeNode(postorder[postorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 后序遍历中「从 左边界 开始到 左边界+size_left_subtree-1」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(postorder, postorder_left, postorder_left+size_left_subtree-1, inorder_left);
        // 递归地构造右子树，并连接到根节点
        // 后序遍历中「从 左边界+size_left_subtree 开始到 右边界-1」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(postorder, postorder_left+size_left_subtree, postorder_right-1, inorder_root + 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder,int[] postorder) {
        int n = inorder.length;
        // 构造哈希映射，帮助我们快速定位根节点，将中序遍历的节点放到index索引map中
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(postorder, 0, n - 1, 0);
    }
}
