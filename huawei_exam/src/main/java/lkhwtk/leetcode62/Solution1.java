package lkhwtk.leetcode62;

import java.util.Arrays;

/**
 * 参考题解：动态规划，对官方题解进行了优化，优化空间复杂度，后边有需求看下
 */
public class Solution1 {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
}
