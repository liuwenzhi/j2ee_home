package lkhwtk.leetcode50;

/**
 * 50. Pow(x, n)
 * 参考题解：50. Pow(x, n) （快速幂，清晰图解）
 * 重点注意下：计算过程中可能出现数组下表越界等问题
 * 可以背一下这个算法
 */
public class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
