package lkhwtk.leetcode81;

/**
 * 81. 搜索旋转排序数组 II
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        for(int num:nums){
            if(num==target){
                return true;
            }
        }
        return false;
    }
}
