package lkhwtk.leetcode304;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 个人第一反应的思路，效率不是很高
 * 2021年8月31日二轮刷题出现超时，而且是测试用例全通过的情况下提示超时
 */
public class NumMatrix {

    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            for(int j=col1;j<=col2;j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
