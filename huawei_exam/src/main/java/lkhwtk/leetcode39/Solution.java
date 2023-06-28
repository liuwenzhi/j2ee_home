package lkhwtk.leetcode39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 39. 组合总和
 * 参考题解：回溯算法 + 剪枝（回溯经典例题详解）
 * 核心思路：回溯+剪枝，解题先画树形图，注意本题和46题存在一定的关联
 * 本解为纯递归，没有剪枝
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        //最外层从0开始搜索
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     * 去重的核心思路：从每一层的第 2个结点开始，都不能再搜索产生同一层结点已经使用过的 candidate 里的元素
     * 重点注意：这里的每一层的第2的节点开始，是指同一个父节点下的多个子节点，同层的前边用过了，后边的分支就不
     * 能用了，会产生重复，后边的分支包括完整的到叶子节点的路径，都不能用前边用过的，如果几个节点不是同一个父节
     * 点，而是共同的祖先节点，则不用考虑同层其他父节点上的子节点用了哪个元素，这里就不能用了，比如题解中第二个
     * 树状图里边，黄框中的内容，倒数第二层：1、0和-1三个节点，上边有两个不同的父节点3和2，这个时候，不需要考
     * 虑左边用了-3，右边就不能用-3，右边的分支只要考虑整体不能用-2即可。
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        //递归结束条件：target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        //target为0的时候，产生一个路径
        if (target == 0) {
            //注意将队列元素转到链表中的方式
            res.add(new ArrayList<>(path));
            return;
        }
        //重点理解这里从 begin 开始搜索的语意，这里的设计保证了同层不会用使用过的candidate 里的元素
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            //注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错，仔细看下本方法上边的注释，这里就好理解了
            dfs(candidates, i, len, target - candidates[i], path, res);
            // 状态重置
            path.removeLast();
        }
    }
}
