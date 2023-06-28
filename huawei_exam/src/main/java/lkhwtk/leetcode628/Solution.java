package lkhwtk.leetcode628;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 628. 三个数的最大乘积
 * 本题包括三种情况：
 * 1、都是正数
 * 2、都是负数
 * 这两种情况，数组排序之后，最大的三数乘积为：最大的三个数的乘积
 * 3、有正有负：此时三数乘积最大值有可能是两个最小的负数*最大的正数，也可能是三个最大数乘积
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
