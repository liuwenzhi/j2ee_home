package lkhwtk.leetcode121;

/**
 * 买卖股票的最佳时期I
 * 非常巧的思路：一次买入，一次卖出，采用类似一个简单的动态规划的思路：
 * 循环遍历数组：在从前向后的遍历过程中用一个minPrice一直记录最小值，
 * 然后用每一天的价格去和最小值做差（最小值是当前为止的最小值），得到
 * 到当天的最大利润，比较当天的最大利润和之前最大的利润，时间复杂度O(n)，空间
 * 复杂度O(1)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrefit = 0;
        for(int i=0;i<prices.length;i++){
            //到i下标为止，最小的价格
            minPrice = Math.min(minPrice,prices[i]);
            //到i下标为止，最大的利润，先求出当天的利润，再和之前的最大利润比较
            maxPrefit = Math.max(maxPrefit,prices[i]-minPrice);
        }
        return maxPrefit;
    }
}
