package lkhwtk.offer07;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * 本题同leetcode105，经过优化之后，效率提升了一倍
 */
public class Solution {

    /**
     * key：节点值，value：中序遍历位置编号
     * 通过indexMap能很有效的通过前序遍历中的节点找到该节点在中序遍历中的位置，避免每次都单独遍历一次inorder数组
     */
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //构造哈希映射，帮助我们快速定位根节点，将中序遍历的索引顺序放到nodeMap中
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, n - 1, 0);
    }

    /**
     * 核心递归遍历方法，相对于105优化点：中序遍历的信息保存到了全局indexMap中，可以优化掉部分中序遍历参数
     * @param preorder 前序遍历数组
     * @param preorder_left 前序遍历左边开始位置编号，注意是遍历数组下标编号，不是具体的节点val
     * @param preorder_right 前序遍历右边结束位置编号
     * @param inorder_left 中序遍历左边开始位置编号
     */
    public TreeNode myBuildTree(int[] preorder, int preorder_left, int preorder_right, int inorder_left) {
        //首先定义递归出口条件
        if (preorder_left > preorder_right) {
            return null;
        }
        //前序遍历中的第一个节点就是根节点，preorder_root也是一个遍历数组的元素编号，这里定义一个它就是便于理解，实际可以去掉
        int preorder_root = preorder_left;
        //通过preorder[preorder_root]找到前序遍历中根节点val，然后拿着这个根节点信息到indexMap找到该节点在中序遍历中的位置
        int inorder_root = indexMap.get(preorder[preorder_root]);
        //通过前序遍历序列把preorder_root下标对应的节点val拿出来，并构建该节点，该节点实际为根节点（递归遍历过程中是子树的根节点）
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //中序遍历根节点的位置-中序遍历左边开始位置，得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素，
        // 在一直往左找子树的过程中，不论前序遍历确认了什么样的范围，只要是纯往左找，中序遍历的开始位置都是0
        root.left = myBuildTree(preorder,preorder_left + 1, preorder_left + size_left_subtree, inorder_left);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素，
        // 往右找，中序遍历的开始位置变成了根节点位置后一个位置
        root.right = myBuildTree(preorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1);
        return root;
    }
}
