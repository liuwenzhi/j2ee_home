package lkhwtk.leetcode191;

/**
 * 参考题解：【负雪明烛】详解位运算，附本题躲坑指南
 * 核心思路：
 * 使用 n & 1 得到二进制末尾是否为 1；
 * 把 n 右移 1 位，直至结束。注意：一定要使用无符号右移，不然负数高位时-1，会导致结果超时
 */
public class Solution2 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
        //使用带符号右移参考
        /*
        int result = 0;
        for(int i = 0; i < 32; i++)
            if(((n >> i) & 1) == 1) result++;
        return result;
        */
    }
}
