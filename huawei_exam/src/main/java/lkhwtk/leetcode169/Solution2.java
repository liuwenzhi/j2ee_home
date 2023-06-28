package lkhwtk.leetcode169;

import java.util.Arrays;

/**
 * 169. 多数元素
 * 最简单的思路，多数元素肯定存在，则先将数组排序，然后取中间位置元素，肯定是多数元素
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
        //或者右移一位，相当于除以2，数组长度肯定大于0，不用考虑符号
        //return nums[nums.length >> 1];
        //return nums[nums.length >>> 1];
    }
}
