package lkhwtk.leetcode1480;

/**
 * 1480. 一维数组的动态和
 */
public class Solution {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        //这个判断没有必要，如果length==0.下边for循环不会走，还是返回nums
        /*if(length==0){
            return nums;
        }*/
        for(int i=1;i<length;i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
