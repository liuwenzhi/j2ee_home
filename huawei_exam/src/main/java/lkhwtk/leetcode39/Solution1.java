package lkhwtk.leetcode39;

import java.util.*;

/**
 * 39. 组合总和
 * 参考题解：回溯算法 + 剪枝（回溯经典例题详解）
 * 核心思路：回溯+剪枝，解题先画树形图，注意本题和46题存在一定的关联
 * 增加剪枝过程，备注：题解中，补充说明这块对递归之前和递归之后，打印
 * 路径这一块讲得不错，在递归算法中，比跟踪代码效果要好很多。
 */
public class Solution1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        //排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            //如果值为负数，跳出这一层循环，不用往下执行了，Solution方案中，是进入递归方法后，判断是否小于0，然后return，实际还是把负值都遍历了一遍
            //本思路先对canditates数组进行排序，排序之后直接在小于0的情况下跳出循环
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}


