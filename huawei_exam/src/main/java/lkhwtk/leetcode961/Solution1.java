package lkhwtk.leetcode961;

/**
 * 官方题解，效果很好，后边有需求再看下
 */
public class Solution1 {
    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }

}
