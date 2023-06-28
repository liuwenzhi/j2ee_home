package lkhwtk.leetcode1124;

/**
 * 1124. 表现良好的最长时间段
 * 个人思路：暴力解法
 * 开始构思是否是动态规划，写出代码之后发现实际思路是暴力解法
 * 暂时重点参考暴力解法
 */
public class Solution {
    public int longestWPI(int[] hours) {
        //创建一个新的数组，把原始数组中大于8的存1，小于8的存-1
        int n = hours.length;
        int[] score = new int[n];
        for (int i=0;i<n;i++){
            score[i] = hours[i] > 8 ? 1 : -1;
        }
        int max = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            int maxDay = 0;
            //内层循环从j=i开始，因为可能有单天的情况，比如669，,696这种，不用等于会被遗漏
            for(int j=i;j<n;j++){
                sum+=score[j];
                if(sum>0){
                    //注意：天数要用i和j来计算
                    maxDay=j-i+1;
                }
            }
            max = Math.max(max,maxDay);
        }
        return max;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] hours = {6,6,9};
        System.out.println(solution.longestWPI(hours));
    }
}
