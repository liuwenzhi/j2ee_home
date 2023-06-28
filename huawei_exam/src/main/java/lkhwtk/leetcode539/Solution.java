package lkhwtk.leetcode539;

import java.util.Arrays;
import java.util.List;

/**
 * 539. 最小时间差
 * 本题注意这么一个细节：["23:59","00:00"]，两个时间点，按照1来算，不是1439
 * 本题的时间格式是小时：分钟，直接统计成分钟数来算
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        //一天最多1440分钟，如果超过这个范围，说明有重复的时间，时间差为0
        int size = timePoints.size();
        if(size>1440){
            return 0;
        }
        //最大时间差
        int min = 1440;
        int[] timeMinutes = new int[size];
        int i=0;
        //将全部小时分钟时间信息转成分钟数
        for(String time:timePoints){
            /*int m1 = Integer.parseInt(time.split(":")[0])*60;
            int m2 = Integer.parseInt(time.split(":")[1]);
            timeMinutes[i++] = m1+m2;*/
            //subString的方式比拆分数组效率要高
            timeMinutes[i++] = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        }
        Arrays.sort(timeMinutes);
        for(int j=timeMinutes.length-1;j>0;j--){
            if(timeMinutes[j]-timeMinutes[j-1]==0){
                return 0;
            }
            min = Math.min(min,timeMinutes[j]-timeMinutes[j-1]);
        }
        //单独比较一下首尾的时间，本题用例跑不完问题在这里，之前上边的转换比较逻辑不能变
        min = Math.min(min,1440+timeMinutes[0]-timeMinutes[size-1]);
        return min;
    }

    public static void main(String[] args){
        String s = "01234";
        //从0开始截取两位
        System.out.println(s.substring(0,2));
        //从第二位开始截取到最后
        System.out.println(s.substring(2));
        //从第三位开始截取到最后
        System.out.println(s.substring(3));
        System.out.println(Integer.parseInt("00"));
        System.out.println(Integer.parseInt("01"));
    }
}
