package lkhwtk.leetcode268;

import java.util.Arrays;

/**
 * 268. 丢失的数字
 */
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for(;i<nums.length;i++){
            if(i<nums[i]){
                break;
            }
        }
        return i;
    }
}
