package lkhwtk.leetcode1545;

/**
 * 参考题解：官方
 * 二轮复习时有需求看下这个题解，对递归的思路进行了优化，极大提升了效率
 */
public class Solution1 {
    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int mid = 1 << (n - 1);
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            k = mid * 2 - k;
            return invert(findKthBit(n - 1, k));
        }
    }

    public char invert(char bit) {
        return (char) ('0' + '1' - bit);
    }
}
