package lkhwtk.leetcode29;

/**
 * 直接使用除法计算的情况下，单独处理一个边界情况即可
 */
public class Solution1 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        return dividend/divisor;
    }
}
