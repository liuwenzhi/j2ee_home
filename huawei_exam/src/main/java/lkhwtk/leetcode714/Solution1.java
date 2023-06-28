package lkhwtk.leetcode714;

/**
 * 动态规划+滚动数组
 */
public class Solution1 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            //第i天不持有股票，取前一天不持有股票和前一天持有股票今天卖掉的最大收益
            int dp_i0 = Math.max(dp0, dp1 + prices[i] - fee);
            //第i天持有股票，取前一天不持有股票和前一天持有股票今天卖掉的最大收益值
            int dp_i1 = Math.max(dp1, dp_i0 - prices[i]);
            dp0 = dp_i0;
            dp1 = dp_i1;
        }
        return dp0;
    }
}
