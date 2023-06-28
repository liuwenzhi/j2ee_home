package lkhwtk.leetcode461;

/**
 * 461. 汉明距离
 * 参考题解：官方
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        //bitCount方法统计一个数字的二进制形式中1的个数，抑或运算是相同为0，不同为1，两个一配合正好搞定本题
        return Integer.bitCount(x ^ y);
    }
}
