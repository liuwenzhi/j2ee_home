package lkhwtk.leetcode1109;

/**
 * 参考题解：航班预订统计
 * 非常好的思路
 */
public class Solution1 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for (int[] booking : bookings) {
            //始发站上来这些人
            counters[booking[0] - 1] += booking[2];
            //到终点站的下一站在减去这些人，最后一班不需要减
            if (booking[1] < n) {
                counters[booking[1]] -= booking[2];
            }
        }
        //每站人数等于前一站人数+本站的变化人数
        for (int i = 1; i < n; ++i) {
            counters[i] += counters[i - 1];
        }
        return counters;
    }

}
