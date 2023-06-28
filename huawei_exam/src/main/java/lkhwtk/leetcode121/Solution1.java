package lkhwtk.leetcode121;

/**
 * 买股票的最佳时期I
 * 基于一维动态规划来实现
 * 动态规划一般分为一维、二维、多维（使用状态压缩），对应形式为 dp(i)dp(i)、dp(i)(j)dp(i)(j)、二进制dp(i)(j)二进制dp(i)(j)。
 *
 * 1. 动态规划做题步骤
 * 明确 dp(i) 应该表示什么（二维情况：dp(i)(j)dp(i)(j)）；
 * 根据 dp(i) 和 dp(i-1) 的关系得出状态转移方程；
 * 确定初始条件，如 dp(0)。
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        //dp[i]表示截止第i天的最大利润（即：当前交易结束后的最大利润），状态转移方程：dp[i] = max(dp[i-1],prices[i]-minPrice)，dp[0] = 0(当天买入、当天卖出结果为0)
        //状态转移方程的核心思路是：基于dp[i-1]已经是第i-1天最大利润，那么，到第i天的时候，存在两种情况，第i天卖或者不卖，不卖就取dp[i-1]
        //卖了，就用第i天的价格减去之前最小的买入价格，实际dp数组中第i天用dp[i-1]来标识，dp数组从0开始计数
        int[] dp = new int[prices.length];
        //第一天买入，只能原价再卖出，收益为0
        dp[0] = 0;
        //第一天最低价格就是prices[0]，没有其它比较
        int minPrice = prices[0];
        int i = 1;
        for(;i<prices.length;i++){
            minPrice = Math.min(prices[i],minPrice);
            dp[i] = Math.max(dp[i-1],prices[i]-minPrice);
        }
        //注意这里返回i-1，代表第i天，for循环中最后还执行了一个i++
        return dp[i-1];
    }

    public static void main(String[] args){
        /*Test solution1 = new Test();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution1.maxProfit(prices));*/
    }
}
