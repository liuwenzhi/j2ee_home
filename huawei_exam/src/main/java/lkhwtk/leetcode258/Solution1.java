package lkhwtk.leetcode258;

/**
 * 思路参考：【Java】O(1)解法的个人理解
 * 作为模板记一下
 */
public class Solution1 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
