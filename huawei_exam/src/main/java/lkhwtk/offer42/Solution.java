package lkhwtk.offer42;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 直接参考53题思路基于动态规划来做即可
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            //到第i个元素，如果前边的最大累加和+元素i < 元素i,则记录到第i个元素，最大子数组和为元素i的值，相当于从第i的元素重新开始记子序列
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;

    }
}
