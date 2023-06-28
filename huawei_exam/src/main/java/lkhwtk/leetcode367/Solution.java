package lkhwtk.leetcode367;

/**
 * 367. 有效的完全平方数
 * 数学思路：首项为1 公差为2的等差数列之和刚好为完全平方数
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int tmp = 1;
        while(num > 0)
        {
            num -= tmp;
            tmp += 2;
        }
        return num == 0;
    }
}
