package lkhwtk.leetcode35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for(;i<nums.length;){
            if(nums[i]<target){
                i++;
            }else if(nums[i]==target){
                return i;
            }else{
                return i;
            }
        }
        return i;
    }
}
