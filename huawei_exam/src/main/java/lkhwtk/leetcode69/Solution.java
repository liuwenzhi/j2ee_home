package lkhwtk.leetcode69;

/**
 * 69. Sqrt(x)
 * 解题思路：牛顿法
 * 本题为数学题目，固定算法
 */
public class Solution {
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}
