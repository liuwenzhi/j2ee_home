package lkhwtk.leetcode33;

/**
 * 33. 搜索旋转排序数组
 * 本题和153题关联较大，注意：153题最外层while循环，low和high的关系可以包含等于
 */
public class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
