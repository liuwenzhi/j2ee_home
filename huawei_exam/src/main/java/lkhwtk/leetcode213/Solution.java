package lkhwtk.leetcode213;

/**
 * 213. 打家劫舍 II
 * 自己根据198题构思出来的思路，和官方题解对上了，因为首尾两个元素不能同时选择，那就单独规划只有头没有尾的内容，
 * 单独规划只有尾没有头的内容，最后比较下这两个结果，注意只有尾没有头元素的情况需要从第二位、第三位开始规划，
 * 所以要增加判断入参数组的长度是否是==2，等于2的时候直接返回两个元素大的那个
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if(length == 2){
            return Math.max(nums[0],nums[1]);
        }
        //dp[i]表示在截止到第i家即第i个位置上的最大值
        int[] dp = new int[length];
        //dp[0]只有一个nums[0]
        dp[0] = nums[0];
        //dp[1]可能是nums[0]也可能是nums[1]
        dp[1] = Math.max(nums[0], nums[1]);
        //从第二位开始进行规划，一直规划到倒数第二位。在当前位置上可以选择这一位，最大值为dp[i - 2] + nums[i]，或者不选择这一位，最大值为dp[i - 1]
        for (int i = 2; i < length-1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int result1 = dp[length-2];
        //接下来是第二步骤，值规划没有头，有尾的部分
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        //从第三位开始规划，一直规划到最后一位
        for (int i = 3; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int result2 = dp[length-1];
        return Math.max(result1,result2);
    }
}
