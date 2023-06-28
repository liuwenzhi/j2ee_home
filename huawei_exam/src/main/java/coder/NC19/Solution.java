package coder.NC19;

/**
 * NC19 连续子数组的最大和
 *
 * 本题同offer42题，可参考leetcode53题思路
 */
public class Solution {

    /**
     * 基于动态规划思路
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        //dp[i]代表截止到第i个元素为止，连续数组的最大和
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for(int i=1;i<array.length;i++){
            //截止到第i个位置的最大值，要么从当前为开始，要么累加到之前的最大值上
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 对动态规划思路优化，讲数组优化为变量
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        int temp = array[0];
        int max = array[0];
        for(int i=1;i<array.length;i++){
            //截止到第i个位置的最大值，要么从当前为开始，要么累加到之前的最大值上
            temp = Math.max(temp+array[i],array[i]);
            if(temp>max){
                max = temp;
            }
        }
        return max;
    }

    /**
     * 老思路，实际和上边动态规划想法一致，缺少对边界的处理，如果原始数组中只有一个元素，则会报异常
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        for (int i = 1; i < arr.length - 1; i++) {
            if(arr[i] + arr[i-1]>arr[i]){
                arr[i] = arr[i] + arr[i-1];
            }
        }
        return arr[arr.length - 1] > 0 ? arr[arr.length - 1] + arr[arr.length - 2] : arr[arr.length - 2];
    }
}
