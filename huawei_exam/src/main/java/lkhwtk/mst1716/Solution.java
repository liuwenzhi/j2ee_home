package lkhwtk.mst1716;

/**
 * 面试题 17.16. 按摩师
 * 核心思路：动态规划，注意入参可能有空数组
 * 本题思路和122题，买卖股票的最佳时期有点像
 */
public class Solution {
    public int massage(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        //dp[i][0]代表不选nums[i]时的最大值，dp[i][1]代表选择nums[i]时的最大值
        int[][] dp = new int[nums.length][2];
        //nums[0]不选择的初始值
        dp[0][0] = 0;
        //nums[0]选择的初始值
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;i++){
            //当前nums[i]不选择，则可以从前一个选择和前一个不选择的状态转移过来
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            //当前nums[i]选择，则只能从前一个不选择转移过来
            dp[i][1] = nums[i]+dp[i-1][0];
        }
        //规划到最后一个元素的时候，结果可能是dp[i][0]，也可能是dp[i][1]，需要比较返回结果
        return dp[nums.length-1][0]>dp[nums.length-1][1]?dp[nums.length-1][0]:dp[nums.length-1][1];

    }
}
