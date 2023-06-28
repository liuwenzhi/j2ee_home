package lkhwtk.leetcode343;

/**
 * 343. 整数拆分
 * 参考题解：343. 整数拆分（数学推导，清晰图解），核心思路：基于数学公式解决
 */
public class Solution {
    public int integerBreak(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if(b == 0) {
            return (int)Math.pow(3, a);
        }
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2;
    }
}
