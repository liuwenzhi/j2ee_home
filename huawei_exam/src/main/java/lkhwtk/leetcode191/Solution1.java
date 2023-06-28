package lkhwtk.leetcode191;

/**
 * 参考题解：官方思路
 * 让n每一位和2的i次幂做与计算，这个思路实际和Solution2思路正好相反，Solution2是判断最后一位，本题是从高位往低位一位一位判断
 * 左移的方案不涉及移动n，但是需要单独做一个1的左移计算
 */
public class Solution1 {
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
