package lkhwtk.leetcode739;

/**
 * 739. 每日温度
 * 暴力法跑完全部用例耗时过多
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(temperatures[j]>temperatures[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        new Solution().dailyTemperatures(a);
    }
}
