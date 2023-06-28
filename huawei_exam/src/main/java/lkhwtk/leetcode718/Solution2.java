package lkhwtk.leetcode718;

/**
 * 基于滑动窗口思路，代码为官方思路
 */
public class Solution2 {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        //从A的不同开始位置取子数组，长度为len，取到这个子数组和B从零开始的子数组进行比较
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        //从B的不同开始位置取子数组，长度len，取到这个子数组和A的从零开始的子数组进行比较
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    /**
     * 对齐数组后进行元素比对，得到最大数组长度
     */
    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }
}
