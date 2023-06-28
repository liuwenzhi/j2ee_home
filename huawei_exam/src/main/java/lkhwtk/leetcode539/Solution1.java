package lkhwtk.leetcode539;

import java.util.Arrays;
import java.util.List;

/**
 * 官方题解，一些字符串处理方式参考下
 */
public class Solution1 {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 1440){
            return 0;
        }
        int[] minutes = new int[timePoints.size()];
        for(int i = 0; i < timePoints.size(); i++){
            String timeStr = timePoints.get(i);
            minutes[i] = Integer.parseInt(timeStr.substring(0, 2)) * 60 + Integer.parseInt(timeStr.substring(3));
        }
        Arrays.sort(minutes, 0, minutes.length);

        int mindiff = 1440;
        for(int i = 1; i < minutes.length; i++){
            mindiff = Math.min(mindiff, minutes[i] - minutes[i-1]);
            if(mindiff == 0)
                return 0;
        }
        mindiff = Math.min(1440 - minutes[minutes.length-1] + minutes[0], mindiff);
        return mindiff;
    }

}
