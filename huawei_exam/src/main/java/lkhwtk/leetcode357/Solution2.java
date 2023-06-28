package lkhwtk.leetcode357;

/**
 * 枚举法求解，可以作为一个模板背一下
 * 参考思路：Java多解法：回溯 / 动态规划 / 枚举
 */
public class Solution2 {
    int[] arr = {1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851, 5611771, 8877691};
    public int countNumbersWithUniqueDigits(int n) {
        return arr[Math.min(n, 10)];
    }
}
