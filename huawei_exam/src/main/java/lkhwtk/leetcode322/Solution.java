package lkhwtk.leetcode322;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 本题是腾讯二面的试题，参考官方题解，本题属于动态规划完全背包问题，即，每一个元素可以被不限制使用
 * 辅助参考题解：一篇文章吃透背包问题！（细致引入+解题模板+例题分析+代码呈现），题解中有完整的完全背包模板
 * 和面试题0811配合看下，0811属于完全背包
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //以完全背包思路思考这个问题：dp[i]代表总额i（0~amount）的最小兑换次数，初始化的时候给全部元素都赋值最大值
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        //定义dp[0]=0，主要是核心算法代码：dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);，当i=coins[j]的时候，
        //表达式：dp[i - coins[j]] + 1 最终结果是0+1=1，也即：等额兑换（比如：5元兑换5元）正好兑换一次
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            /*for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    //在选择coins[j]的情况下进行下选择
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }*/
            for (int coin:coins) {
                //注意：coins数组不是有序的，如果是先排序，然后在这个if后边再加一个else，时间效率没有实际的提升
                if (coin <= i) {
                    //在选择coins[j]的情况下进行下选择
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //返回最小值，不大于的时候才返回，dp[amount]赋初值是amount+1，判断是否大于amount实际就是看下这个值有没有改变
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
