package lkhwtk.leetcode714;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 本题思路和122题基本一致，就是加了手续费
 *
 * 参考题解：买卖股票的最佳时机含手续费 官方
 * 纯动态规划思路
 * 注意动态规划模型思路：dp[i][0]代表第i天交易完成之后手里没有股票的最大利润，dp[i][1]代表第i天交易完成之后手里有一支股票的最大利润
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //注意，手续费是在卖出股票的时候缴费，买入的时候不交手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
