package lkhwtk.leetcode48;

/**
 * 48. 旋转图像
 * 参考题解：官方
 * 思路一：暴力解法，经过90°旋转之后，原来第i行的元素，变成了倒数第i列的元素
 * 阵中的行列从0开始计数，对于矩阵中的元素matrix[row][col]，旋转90°之后变成了matrix[col][n-row-1]
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length==0){
            return;
        }
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix_new[j][n-i-1] = matrix[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }
}
