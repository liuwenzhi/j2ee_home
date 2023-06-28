package lkhwtk.leetcode48;

/**
 * 参考题解：【数据结构和算法】两种实现方式，都击败了100%的用户
 * 先上下翻转，再按照主对角线翻转
 */
public class Solution1 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //先上下交换，直接取二维数组的一维行进行交换。
        for (int i = 0; i < length / 2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //再按照对角线交换
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
