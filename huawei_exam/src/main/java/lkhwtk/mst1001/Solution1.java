package lkhwtk.mst1001;

import java.util.Arrays;

/**
 * 强行合并再排序思路，时空复杂度和Solution差不多
 */
public class Solution1 {
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; ++i) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }
}
