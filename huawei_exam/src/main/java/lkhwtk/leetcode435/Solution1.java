package lkhwtk.leetcode435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 参考思路：无重叠区间 官方
 * 官方的动态规划思路不用参考，效率很低，贪心算法和本人的思路一致，而且官方答案避免了
 * 单独使用一个list列表，right = intervals[i][1];直接使用一个right记录这个值
 * 时间和空间都有提升，时间上应该是避免了list列表操作，减少1ms时间
 */
public class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

}
