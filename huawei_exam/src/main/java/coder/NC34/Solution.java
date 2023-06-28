package coder.NC34;

/**
 * NC34 求路径
 * 本题同leetcode62
 */
public class Solution {
    public int uniquePaths (int m, int n) {
        // write code here
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
