package lkhwtk.leetcode437;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * 核心思路：
 * 前缀和的概念：
 * 一个节点的前缀和就是该节点到根之间的路径和。
 * 前缀和的意义：
 * 因为对于同一路径上的两个节点，上面的节点是下面节点的祖先节点，所以其前缀和之差即是这两个节点间的路径和（不包含祖先节点的值）。
 *
 * 参考题解：让你秒懂的回溯 + 前缀和实现
 *           一篇文章解决所有二叉树路径问题（问题分析+分类模板+题目剖析），这个题解的动态图说明非常不错
 *           对前缀和解法的一点解释，这个题解是对官方题解的详细解释
 *           官方
 *  本题很复杂，把几个题解组合起来看效果能好一些
 */
public class Solution {

    /**存放前缀和的map，key是前缀和, value是大小为key的前缀和出现的次数*/
    Map<Integer, Integer> prefixMap;

    /**目标和*/
    int target;

    public int pathSum(TreeNode root, int sum) {
        prefixMap = new HashMap<>();
        target = sum;
        //前缀和为0的一条路径，这个细节非常重要，比如root节点是1，要找的路径和是1，
        //根据curSum-target这个key，需要找到一个值，具体可参考main测试函数，按照本
        //题算法，前缀和路径和的计算不包括先祖节点，前缀和为0，路径为1相当于一个补充的点，这个0,1值和根节点没有任何关系
        prefixMap.put(0, 1);
        return recur(root, 0);
    }

    private int recur(TreeNode node, int curSum) {
        // 1.递归终止条件
        if(node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        curSum += node.val;
        //---核心代码：注意从a节点到b节点的前缀和等于target，此时的节点路径是a到b，但不包括a，前开后闭
        // 看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixMap.getOrDefault(curSum - target, 0);
        // 更新路径上当前节点前缀和的个数，算上当前节点
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);
        // 3.进入下一层，注意之前个人想不通的地方，如何保证计算路径的两个节点具有直系血缘关系，直接递归左右子树，然后单独计算
        int left = recur(node.left, curSum);
        int right = recur(node.right, curSum);
        res = res + left + right;
        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);

        return res;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-3);
        root.left = node1;
        node1.left = node2;
        Solution solution = new Solution();
        solution.pathSum(root,1);
    }

}
