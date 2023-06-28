package lkhwtk.leetcode867;

/**
 * 867. 转置矩阵
 * 核心思路：行换成同序数的列，第一行变成第一列，第二行变成第二列
 */
public class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
