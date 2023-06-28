package lkhwtk.offer53_II;

/**
 * 本思路同268题
 */
public class Solution2 {
    public int missingNumber(int[] nums) {
        //初始化missing为nums.length，数组中能够表示出nums.length这个值，但是表示不出nums.length这一位，
        int missing = nums.length;
        for(int i=0;i<nums.length;i++){
            missing^=i^nums[i];
        }
        return missing;
    }
}
