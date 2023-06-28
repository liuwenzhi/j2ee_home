package lkhwtk.leetcode62;

import java.util.Arrays;

/**
 * 思路参考：官方题解，官方的视频说明不错，边界上的方块路径都是1，可以这么来理解：从左上角到任何一个边界上的点，只有一条路径，
 *           因为边界上的点对动态规划方程：f(i,j)=f(i−1,j)+f(i,j−1)计算会产生影响，所以提前算出来。另外注意一个地方：本题题目
 *           和例子说明都没有问题，代表行，n代表列，题解视频中对3*2这个说明说反了，例题中给的是对的
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        //f[i][j]代表走到（i,j）这个位置不同的路径数
        int[][] f = new int[m][n];
        //先把边界都设置为1
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        //基于状态转移方程：f(i,j)=f(i−1,j)+f(i,j−1) 去计算规划
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
