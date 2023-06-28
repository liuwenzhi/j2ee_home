package lkhwtk.leetcode1701;

/**
 * 对Solution进行一步优化，减少一次循环，但是木有实际效果
 */
public class Solution1 {
    public double averageWaitingTime(int[][] customers) {
        //顾客人数
        int customerNum = customers.length;
        //总共等待时间，注意这里一定要使用long类型，不然后边计算会溢出导致结果不正确，总共等待时间初始化为第一个客人的做菜时间
        long totalWaitTime = customers[0][1];
        //下一次做菜开始时间，这里减少了一次循环的时间
        long startTime = customers[0][0]+customers[0][1];
        for(int i=1;i<customerNum;i++){
            if(startTime<customers[i][0]){
                //第一单的情况，或者是实际开始时间比顾客到达时间早，则start要修改为顾客到达时间
                startTime = customers[i][0];
            }else if(startTime>customers[i][0]){
                //如果开始时间比顾客到达时间晚，则要增加顾客等待的时间，直接累加到总的等待时间里边即可
                totalWaitTime+=(startTime-customers[i][0]);
            }
            //等待时间累加做菜时间
            totalWaitTime += customers[i][1];
            //下一次开始时间累加做菜时间
            startTime+=customers[i][1];
        }
        //return Double.valueOf(totalWaitTime+"")/customerNum; 这种返回方式会比下边这种返回方式慢5ms左右，时间效率差的非常明显
        return totalWaitTime/(double)customerNum;
    }
}
