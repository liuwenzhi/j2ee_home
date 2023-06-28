package lkhwtk.leetcode122;

/**
 * 对Solution进行优化，因为每一天的股票价格之和前一天的价格优化，不建立二维数组，直接定义两个变量
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //最开始不持有股票没有收益
        int dp0 = 0;
        //最开始持有股票收益为 -当天股票价格
        int dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            //第i天不持有股票的收益，从前一天不持有股票收益和前一天持有今天卖出的收益来比较
            int dp_i0 = Math.max(dp0, dp1 + prices[i]);
            //第i天持有股票的收益，从前一天持有股票的收益和前一天不持有今天买入后的收益来比较
            int dp_i1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = dp_i0;
            dp1 = dp_i1;
        }
        //动态规划到最后一步，不持有股票的收益才是最大的收益
        return dp0;
    }
}
