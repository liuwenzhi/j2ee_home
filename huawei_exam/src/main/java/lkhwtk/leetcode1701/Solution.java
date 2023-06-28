package lkhwtk.leetcode1701;

/**
 * 1701. 平均等待时间
 */
public class Solution {
    public double averageWaitingTime(int[][] customers) {
        //顾客人数
        int customerNum = customers.length;
        //总共等待时间，注意这里一定要使用long类型，不然后边计算会溢出导致结果不正确
        long totalWaitTime = 0;
        //下一次做菜开始时间
        long startTime = -1;
        for(int i=0;i<customerNum;i++){
            if(startTime<customers[i][0]){
                //第一单的情况，或者是实际开始时间比顾客到达时间早，则start要修改为顾客到达时间
                startTime = customers[i][0];
            }else if(startTime>customers[i][0]){
                //如果开始时间比顾客到达时间晚，则要增加顾客等待的时间，直接累加到总的等待时间里边即可
                totalWaitTime+=(startTime-customers[i][0]);
            }
            //每次累加做菜时间到等待时间中
            totalWaitTime += customers[i][1];
            //累加做菜时间到下一次开始时间中
            startTime+=customers[i][1];
        }
        //return Double.valueOf(totalWaitTime+"")/customerNum; 这种返回方式会比下边这种返回方式慢5ms左右，时间效率差的非常明显
        return totalWaitTime/(double)customerNum;
    }

    public static void main(String[] args){
        int[][] customers = {{2,3},{6,3},{7,5},{11,3},{15,2},{18,1}};
        Solution solution = new Solution();
        System.out.println(solution.averageWaitingTime(customers));
    }
}
