package lkhwtk.leetcode231;

/**
 * 231. 2的幂
 * 参考思路：2 的幂 （位运算，极简解法+图表解析）
 * 本题思路十分巧妙，学习下
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
