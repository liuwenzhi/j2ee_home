package lkhwtk.leetcode973;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 973. 最接近原点的 K 个点
 * 参考题解：官方，本题对数组的排序和提取操作再看下
 */
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, k);
    }
}
