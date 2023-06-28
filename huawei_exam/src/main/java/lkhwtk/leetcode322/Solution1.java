package lkhwtk.leetcode322;

import java.util.Arrays;

/**
 * 本题作为完全背包题目，内外层for循环可以互换位置，标准模板是外层coin，内层amount，避免出现6=1+5,6=5+1这种重复的情况
 * 本题求的是最少硬币个数，不用考虑去重的情况，面试题0811需要单独考虑，因为可能出现6=1+5和6=5+1这种重复情况
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //以0~1背包思路思考这个问题：dp[i]代表总额i（0~amount）的最小兑换次数，初始化的时候给全部元素都赋值最大值
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int coin : coins){
            for (int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        //返回最小值，不大于的时候才返回
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
