package lkhwtk.leetcode215;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length-k];
    }
}
