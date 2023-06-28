package lkhwtk.mst0107;

/**
 * 48题Solution1思路，要旋转90°，先上下交换，然后按照主对角线交换一次
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
