package coder.NC18;

/**
 * NC18 顺时针旋转矩阵
 * 矩阵行列数相等，方阵可以这么搞，按照固定算法
 */
public class Solution {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][] temp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                temp[j][n-1-i]=mat[i][j];
            }
        }
        return temp;
    }
}
