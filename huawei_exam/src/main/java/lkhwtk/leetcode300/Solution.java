package lkhwtk.leetcode300;

/**
 * 300. 最长递增子序列
 * 解题思路：动态规划，参考华为机试103题，走梅花桩那道题
 * 题解中用到的思路和官方思路实际一致，时空效率近似。可参考下官方题解中的动态图，效果非常明显
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp[i]代表到第i个元素(以第i个元素结尾)，递增子序列的大小
        int[] dp = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            //初始化为1，初始化非常重要，进行状态转移，初始化保证了多次转移的正确性
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                //如果发现前边有小的元素，就基于那个dp值累加1
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        //初始化一个max为1，然后遍历dp数组得到一个最大的距离值
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
