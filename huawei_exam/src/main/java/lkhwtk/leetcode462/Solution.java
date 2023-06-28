package lkhwtk.leetcode462;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * 参考题解：官方
 * 本题是一个数学问题，先排序，找中位数，然后计算每一个数和中位数的距离和
 */
public class Solution {
    public int minMoves2(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int sum = 0;
        //确认中位数位置
        int pos = nums.length / 2;
        for (int num : nums) {
            sum += Math.abs(nums[pos] - num);
        }
        return sum;
    }
}
