package lkhwtk.offer57;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 直接遍历会超时，因为数组有序，参考使用双指针
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]<target){
                i++;
            }else if(nums[i]+nums[j]>target){
                j--;
            }else{
                result[0] = nums[i];
                result[1] = nums[j];
                break;
            }
        }
        return result;
    }
}
