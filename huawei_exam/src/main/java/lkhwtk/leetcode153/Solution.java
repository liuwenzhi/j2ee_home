package lkhwtk.leetcode153;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 个人思路：未体现出旋转数组的设计
 * 本题和33题属于一种类型
 */
public class Solution {
    public int findMin(int[] nums) {
        int min  = nums[0];
        for(int i=1;i<nums.length;i++){
            min = Math.min(min,nums[i]);
        }
        return min;
    }
}
