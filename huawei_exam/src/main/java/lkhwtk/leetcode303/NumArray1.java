package lkhwtk.leetcode303;

/**
 * 前缀和思路
 */
public class NumArray1 {
    private int[] sums;

    public NumArray1(int[] nums) {
        int n = nums.length;
        //前缀和数组长度比nums大1，需要记录一个首位0
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

}
