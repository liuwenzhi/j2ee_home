package lkhwtk.offer16;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 参考leetcode50题题解，快速幂
 * 计算x的n次幂，x的1次幂，2次幂...一步一步计算到n次幂
 */
public class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0f) {
            return 0.0d;
        }
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            //取余数b%2等价于b&1
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            //b向下整除2
            b >>= 1;
        }
        return res;

    }
}
