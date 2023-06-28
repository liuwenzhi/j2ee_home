package lkhwtk.leetcode172;

/**
 * 参考题解：详细通俗的思路分析
 */
public class Solution1 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

}
