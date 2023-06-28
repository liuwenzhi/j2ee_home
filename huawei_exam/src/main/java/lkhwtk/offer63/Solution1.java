package lkhwtk.offer63;

/**
 * 效率更高的一个思路
 * 本题和121题都验证了这个算法效率更高
 */
public class Solution1 {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            //如果当前价格小于最小价格，直接记录最小价格为当前价格，此时不用计算当天进行卖出，如果第一天价格是最小的，
            //这时候和MAX_VALUE进行比较，那么后边每一天都价格都减去这个值求一个最大的收益，如果第一天价格不是最小的，
            //后边会有更小的价格，那么最大收益也肯定是减去更小的价格，而不是减去第一天的，其他情况肯定是价格小处于减数，
            //价格大才处于被减数，本题算法能够减少很大的计算量
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                //只有当前价格大于最小价格的情况下，才进行卖出
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
