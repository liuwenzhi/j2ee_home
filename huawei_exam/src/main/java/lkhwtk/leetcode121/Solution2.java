package lkhwtk.leetcode121;

/**
 * 参考Offer63题解，这个思路更清晰，核心点还是找当前位置之前的最小价格和最大利润
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                //当前价格小于最低价格，肯定不卖
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                //只有当前价格大于最小价格的情况下，才进行卖出
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
