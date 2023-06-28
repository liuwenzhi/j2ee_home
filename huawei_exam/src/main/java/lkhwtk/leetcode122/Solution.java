package lkhwtk.leetcode122;

/**
 * 122. 买卖股票的最佳时机 II
 * 题目中两个点注意下：
 * 1.可以多次买卖一支股票，题目数据组中的价格均为同一支股票的价格
 * 2.不能同时交易多次，一定要卖出去之前的股票之后，再买卖新的股票
 *
 * 题解参考：买卖股票的最佳时机 II 官方
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //n*2维动态规划数组，dp[i][0]是第i天交易后不持有股票的最大收益，dp[i][1]是第i天交易后持有股票的最大收益
        int[][] dp = new int[n][2];
        //最开始不持有股票没有收益
        dp[0][0] = 0;
        //最开始持有股票收益为 -当天股票价格，第1天（i=0）只能买
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            //第i天不持有股票的收益，从前一天不持有股票收益和前一天持有今天卖出的收益来比较
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //第i天持有股票的收益，从前一天持有股票的收益和前一天不持有今天买入后的收益来比较
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //动态规划到最后一步，不持有股票的收益才是最大的收益
        return dp[n - 1][0];
    }
}
