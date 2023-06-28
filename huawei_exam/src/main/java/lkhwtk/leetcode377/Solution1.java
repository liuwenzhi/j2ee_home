package lkhwtk.leetcode377;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 注意：本题使用递归+回溯的方式，参考了39题，这个解法能跑完60%的测试用例，会有部分用例超时，没有剪枝的设计导致。
 */
public class Solution1 {
    private int res = 0;
    public int combinationSum4(int[] nums, int target) {
        Deque<Integer> path = new ArrayDeque<>();
        //最外层从0开始搜索
        dfs(nums, target, path);
        return res;
    }

    private void dfs(int[] nums, int target, Deque<Integer> path) {
        //递归结束条件：target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        //target为0的时候，产生一个路径
        if (target == 0) {
            res++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            path.addLast(nums[i]);
            //注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错，仔细看下本方法上边的注释，这里就好理解了
            dfs(nums,target-nums[i],path);
            // 状态重置
            path.removeLast();
        }
    }
}
