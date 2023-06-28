package lkhwtk.leetcode1450;

/**
 * 1450. 在既定时间做作业的学生人数
 * 本题二轮复习直接过
 */
public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for(int i=0;i<startTime.length;i++){
            if(queryTime>=startTime[i]&&queryTime<=endTime[i]){
                result++;
            }
        }
        return result;
    }
}
