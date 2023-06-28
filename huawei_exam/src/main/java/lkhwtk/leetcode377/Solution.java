package lkhwtk.leetcode377;

/**
 * 377. 组合总和 Ⅳ
 * 参考题解：官方
 * 核心思路：动态规划完全背包，参考322,518和面试题08.11
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //两层for循环，外层是目标值，内层是入参数组，这个设计是考虑排列，不同顺序都是不同的结果 {1,1,2}和{1,2,1}算作不同的结果，
        //如果是外层for循环是num，内层是target，则考虑的是组合结果，不同的顺序都是相同的结果，518和面试题08.11是这个思路
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                //i是当前target值，num是数组中元素，可以这么来理解，每次把num当成组成i的最后一个元素，统计具体的组合数
                //以例题为例：比如i==4，num=1，这个时候就去统计dp[3],dp[3]去统计dp[2],dp[1],dp[2]还要去统计dp[1]，这样
                //就能理解[1,1,1,1]这个结果组合是怎么产生的，其他的组合都可以按照这个思路去推
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        /*
        算法中：dp[0] = 1
                dp[1] = dp[0] = 1
                dp[2] = dp[1]+dp[0] = 1+1=2
                dp[3] = dp[2]+dp[1]+dp[0] = 4
                dp[4] = dp[3]+dp[2]+dp[1]=7
                dp[5] = dp[4]+dp[3]+dp[2]=13
        */
        int target = 5;
        System.out.println(solution.combinationSum4(nums,target));
    }
}
