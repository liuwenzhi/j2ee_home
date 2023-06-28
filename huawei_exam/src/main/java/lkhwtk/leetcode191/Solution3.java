package lkhwtk.leetcode191;

/**
 * 参考说明：官方，【负雪明烛】详解位运算，附本题躲坑指南
 * 这个思路记一下，n和n-1做与操作，只要不等于0，就把结果累加1
 */
public class Solution3 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += 1;
            n &= n - 1;
        }
        return res;
    }
}
