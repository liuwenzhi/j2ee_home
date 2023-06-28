package lkhwtk.leetcode120;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 参考题解：官方，后边的空间优化方案，二轮测试的时候感兴趣在看下，通过状态转移方程本身总结规律进行优化
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            //f[i][0]只能从f[i-1][0]规划过来
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            //每一个行除了首位两个元素，其他位置的节点可以从f[i - 1][j - 1], f[i - 1][j]两个位置规划过来
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            //每行最后一个节点只能从左上角的点规划过来
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        //到最后一行去找路径最小值，初始化为最后一行第一个值，然后通过for循环遍历寻找最后一行的最小值
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
