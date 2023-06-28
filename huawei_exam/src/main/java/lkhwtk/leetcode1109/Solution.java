package lkhwtk.leetcode1109;

import java.util.HashMap;
import java.util.Map;

/**
 * 1109. 航班预订统计
 * 本题读明白题之后，其实不难，就是玩二维数组找值计算，主要是n，作为入参，实际是n个航班，
 * 从1到n进行编号
 * 纯个人思路：耗时有点多，空间复杂度还好
 */
public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        int rows = bookings.length;
        for(int i=0;i<rows;i++){
            //起飞站
            int start = bookings[i][0];
            //降落站
            int end = bookings[i][1];
            //实际座位数
            int seats = bookings[i][2];
            //注意题目要求：从start到end每个航班都预定了seats
            for(int j=start;j<=end;j++) {
                //注意：航班编号从1开始
                result[j - 1] += seats;
            }
        }
        return result;
    }
}
