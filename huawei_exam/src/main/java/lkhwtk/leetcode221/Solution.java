package lkhwtk.leetcode221;

/**
 * 221. 最大正方形
 * 参考题解：官方，核心思路：动态规划
 * 备注：官方题解给出了状态转移方程的证明链接，本题dp存放边长最合适，存放面积会导致中间过程计算复杂
 * 本题直接记一下动态规划的结论
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        //2021年9月1日二轮刷题去掉下边边界判断，题目的说明部分已经给出了矩阵的范围
        /*if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }*/
        int rows = matrix.length, columns = matrix[0].length;
        //二维动态规划数组，存放正方形边长信息，dp[i][j]的值，取决于上方dp[i-1][j]，左侧dp[i][j-1]，左上dp[i-1][j-1]，
        //这三个值中的最小值结合当前位置的值进行判断，相当酷的思路
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //考虑数组元素为1的情况
                if (matrix[i][j] == '1') {
                    //遍历元素位置在上边界或者左边界上，以(i,j)为右下角的正方形边长只能是1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        //状态转移方程核心内容，上方dp[i-1][j]，左侧dp[i][j-1]，左上dp[i-1][j-1]三个位置最小值+1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    //取最大边长值
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        //正方形边长*边长，最终得出最大正方形面积
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

}
