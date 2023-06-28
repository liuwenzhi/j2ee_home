package coder.NC59;

/**
 * NC59 矩阵的最小路径和
 */
public class Soluction {
    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        int[][]  dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        //初始化第一列
        for(int i =1; i< matrix.length; i++) {
            dp[i][0] =  dp[i-1][0] + matrix[i][0];
        }
        //初始化第一行
        for(int i =1; i< matrix[0].length; i++) {
            dp[0][i] =  dp[0][i-1] + matrix[0][i];
        }

        //基于动态规划计算其它值
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        //返回最后一个位置的值
        return dp[matrix.length-1][matrix[0].length-1];
    }
}
