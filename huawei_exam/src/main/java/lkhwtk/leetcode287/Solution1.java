package lkhwtk.leetcode287;

import java.util.Arrays;

/**
 * 个人思路2：排序改了数组，时间更高，空间降低了很多。
 */
public class Solution1 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
}
