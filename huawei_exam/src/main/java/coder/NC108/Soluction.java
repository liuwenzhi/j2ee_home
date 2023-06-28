package coder.NC108;

/**
 * NC108 最大正方形
 * 本题同leetcode221，基本一个固定的模板套路。
 */
public class Soluction {
    public int solve (char[][] matrix) {
        // write code here
        // write code here
        if(matrix.length ==0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //dp[i][j]代表到(i,j)这个位置，最大正方形的边长
        int[][] dp = new int[rows][cols];
        int maxSquareLength = 0;
        //第一列处理
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == '1') dp[i][0] = 1;
        }
        //第一行处理
        for(int i = 0; i < cols; i++){
            if(matrix[0][i] == '1') dp[0][i] = 1;
        }
        //找动态规划矩阵当前位置元素，取它的上，左，左上三个位置上最小的值
        for(int  i =1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    if(dp[i][j] > maxSquareLength) maxSquareLength = dp[i][j];
                }
            }
        }
        return maxSquareLength*maxSquareLength;
    }
}
