package lkhwtk.leetcode48;

/**
 * 参考题解：【数据结构和算法】两种实现方式，都击败了100%的用户
 * 直接旋转，这个思路非常巧，背下来吧。
 */
public class Solution2 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //因为是对称的，只需要计算循环前半行即可
        for (int i = 0; i < length / 2; i++)
            for (int j = i; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                int m = length - j - 1;
                int n = length - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
    }

}
