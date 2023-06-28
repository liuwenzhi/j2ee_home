package lkhwtk.leetcode1139;

/**
 * 1139. 最大的以 1 为边界的正方形
 * 注意：本题和221题存在不同，221题是围成的正方形全都是1，本题是外边界是1就行，本题要是也采用动态规划得用三维dp数组，
 * 还是基于右下角这个点，第三维度：dp[i][j][0]代表(i,j)左边连续的1的个数，dp[i][j][1]代表(i,j)上边连续的1的个数
 * 包括自身，核心思路也是从右下角这个地方开始看
 * 参考题解：Java 动态规划
 */
public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j][0]: i,j左边连续的1的个数
        //dp[i][j][1]: i,j上边连续的1的个数
        int[][][] dp = new int[m+1][n+1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //注意：动态规划涉及到通过前一个元素进行计算，同时没有单独处理边界，初始化为length+1更合适，这里通过算法不需要单独考虑边界，更简单
                //这里的dp[i][j][]实际是基于grid[i-1][j-1]这个元素的规划值
                if (grid[i-1][j-1] == 1){
                    dp[i][j][0] = 1 + dp[i][j-1][0];
                    dp[i][j][1] = 1 + dp[i-1][j][1];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //找左边和上边最短边，那条边不一定是合法的边长，如果该边长不合法就需要缩减边长，直到找到合法的
                for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--){
                    //验证边长是否合法，可参考题解中图的说明来理解，左边顶点上边长，上方顶点左边长是否都大于等于边长
                    //注意-side+1这个设计，算上头和尾两个点，头和尾之间的长度正好是side
                    if (dp[i][j-side+1][1] >= side && dp[i-side+1][j][0] >= side){
                        res = Math.max(res, side);
                        //注意：本题要找的是最大正方形子网络，更短的就没必要考虑了，最终拿到边长之后，
                        //做一个边长的乘积就求出了最大正方形自网络中元素的数量
                        break;
                    }
                }
            }
        }
        return res * res;
    }
}
