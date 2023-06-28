package lkhwtk.leetcode198;

/**
 * 198. 打家劫舍
 * 解题参考：打家劫舍 官方
 *
 * 纯动态规划方式：时间复杂度 O(N),空间复杂度O(N)
 * 需要借助一个一维数组，以空间换取时间
 *
 * 本题思路和122题有些类似
 */
public class Solution {
    public int rob(int[] nums) {
        //这一步验证去掉，题目说明中已经给出：1 <= nums.length <= 100
        /*if (nums == null || nums.length == 0) {
            return 0;
        }*/
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        //dp[i]表示在截止到第i家即第i个位置上的最大值
        int[] dp = new int[length];
        //dp[0]只有一个nums[0]
        dp[0] = nums[0];
        //dp[1]可能是nums[0]也可能是nums[1]
        dp[1] = Math.max(nums[0], nums[1]);
        //从第二位开始进行规划，可以选择这一位，最大值为dp[i - 2] + nums[i]，或者不选择这一位，最大值为dp[i - 1]
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
