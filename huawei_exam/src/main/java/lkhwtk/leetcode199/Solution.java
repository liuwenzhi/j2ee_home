package lkhwtk.leetcode199;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * 思路参考：二叉树的右视图 官方
 * 本题最直接思路：广度优先遍历，把每一层最右边的节点拿出来
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //二叉树每一层最大深度map，key：层数，value：节点值
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        //初始化最大深度变量
        int max_depth = -1;
        //注意队列的初始化方式，初始化为ListedList，nodeQueue存放树的节点，depthQueue存放深度值，为树的实际深度
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        //先放根节点和深度0信息到队列中
        nodeQueue.add(root);
        depthQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int depth = depthQueue.poll();
            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);
                /*由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可，下边逻辑先放左子树，
                再放右子树，同一个key：depth值的情况下，左子树存一次，右子树存一次，右子树会替换掉左子树*/
                rightmostValueAtDepth.put(depth, node.val);
                //如果没有左右子树存进来也没事，在本层if循环中会屏蔽掉null，一个node会对应一个depth，即使节点为null，对应的depth也弹出来了
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                //下边添加了同一个值，两次，从单一一个子树看，先遍历左节点，再遍历右节点，然后右节点的值在rightmostValueAtDepth中把左节点的值替换掉
                //从同一层的角度来看，右边的节点每次都会替换掉左边的节点
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        return rightView;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;
        solution.rightSideView(root);
    }
}
