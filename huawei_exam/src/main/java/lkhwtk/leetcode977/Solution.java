package lkhwtk.leetcode977;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * 个人思路：暴力解法
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
