package lkhwtk.leetcode40;

import java.util.*;

/**
 * 40. 组合总和 II
 * 参考题解：回溯算法 + 剪枝（Java、Python）
 * 算法的图的部分不好理解的点：图的小字部分，注意这样一句话：同一层节点，如果上一层减去的数相同，只需要保留第一个分支的结果。
 * 这句话表达了：针对于图中，同一层节点，如果是来自于一个父节点的情况下，如果减去的数相同，只需要保留第一个。本题和39题在入
 * 参这里有不同，39题入参的数组是不包含重复元素的，本题是可以有重复元素的。本题涉及到先对数组排序，排序之后，每条路径上不能
 * 删除同层前边节点已经选择了的数据。
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        //本题元素是包含重复的，必须先排序一步
        Arrays.sort(candidates);
        //队列选择和39题一致
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param len        冗余变量
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param target     表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            //递归出口1的设计实际和39题Solution1的思路一致
            if (target - candidates[i] < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，如果有重复元素，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            // 调试语句 ①
            // System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, target - candidates[i], path, res);

            path.removeLast();
            // 调试语句 ②
            // System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }

}
