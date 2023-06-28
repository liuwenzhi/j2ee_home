package lkhwtk.leetcode863;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * 参考题解：官方
 * 核心思路：因为是随便找一个节点找距离K，除了搜索节点的左右子树之外，可以继续搜索父节点，先遍历一遍二叉树，
 * 把每个节点的父节点记录下来，再通过递归进行父节点一层一层搜索。
 * 备注：本题一轮刷题时间是7月23日，官方题解在7月28日给出。
 */
public class Solution {
    /**
     * 记录节点父节点的map集合
     */
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个结点的父结点
        findParents(root);
        // 从 target 出发 DFS，寻找所有深度为 k 的结点
        findAns(target, null, 0, k);
        return ans;
    }

    /**
     * 给节点找父节点，分别处理左子树和右子树
     */
    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    /**
     * 从node出发，通过depth变量配合找所有距离为k的节点
     * node初始化为target节点
     * findAns(target, null, 0, k);
     * 递归方法中from节点是单独加的，因为递归过程中有两个递归往下找，第三个递归往上找，可能出现遍历重复路径的情况
     * 比如第三个递归传参是父节点，左孩子，到第一个递归了父节点的左孩子正好等于来源节点，这个时候就是一种遍历重复路径的情况。
     */
    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }
        //从node左子树开始找，初始化from为null，如果target没有左子树就不走了（null != null）
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        //从node左子树开始找，初始化from为null，如果target没有左子树就不走了（null != null）
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        //从node父节点开始找，上边两个递归是往下找子节点，这个递归是往上找父节点，增加了from节点，避免重复访问节点，比如
        //判断from节点，避免root搜到root.left再从root.left搜回root的情况，上边两个if判断除了判断null之外，核心也是避免和找父节点的时候出现重复路径相关
        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }
}
