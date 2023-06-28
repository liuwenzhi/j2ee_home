package lkhwtk.leetcode53;

/**
 * 53. 最大子序和
 * 注意：本题题目说明略有问题，本题找的是最大子数组，不是子序列，子数组是连续的，子序列不连续
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            //到第i个元素，如果前边的最大累加和+元素i < 元素i,则记录到第i个元素，最大子序列和为元素i的值，相当于从第i的元素重新开始记子数组
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}
