package lkhwtk.leetcode378;

import java.util.Arrays;

/**
 * 定义一个一维数组，直接排序的思路，可以参考下
 */
public class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }
}
