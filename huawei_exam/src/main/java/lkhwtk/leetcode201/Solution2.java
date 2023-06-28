package lkhwtk.leetcode201;

/**
 * 寻找公共前缀的优化：Brian Kernighan 算法
 * 每次抹去最右边的1，一直找到公共前缀,
 */
public class Solution2 {
    public int rangeBitwiseAnd(int m, int n) {
        //注意：这里条件是<,和solution1中的思路不同
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }
}
