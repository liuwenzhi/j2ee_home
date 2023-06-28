package lkhwtk.offer63;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 本题同leetcode121题
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //记录一个最小买入价格，该最小价格为截止至第i天为止的最小价格
        int minPrice = Integer.MAX_VALUE;
        //最大收益
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            //最小价格和当前价格比较更新
            minPrice = Math.min(minPrice,prices[i]);
            //计算当天收益，用当天的价格减去最小价格
            int profit = prices[i] - minPrice;
            //用当天价格减去当前最小买入价格，得到当天的最大收益，然后和最大收益进行比较
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
