package lkhwtk.leetcode326;

/**
 * 326. 3的幂
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        //如果从3出发，用乘法会超时，用除法和取余能节省很大时间
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
