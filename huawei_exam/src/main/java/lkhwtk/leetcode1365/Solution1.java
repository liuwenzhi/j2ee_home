package lkhwtk.leetcode1365;

/**
 * 对Solution进行优化，用整形数组代替Map，注意题解中提示信息：
 * 0 <= nums[i] <= 100
 */
public class Solution1 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cache = new int[101];
        //cache缓存数组首先记录nums数组中每个整数出现的次数，nums数组中整数值代表cache数组下标
        for(int i=0;i<nums.length;i++){
            cache[nums[i]]++;
        }
        //统计cache数组前缀和，前缀和统计完成后，对于cache数组中第i个数字，cache[i-1]就是小于它的个数
        for (int i = 1; i <= 100; i++) {
            cache[i] += cache[i - 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i] == 0 ? 0 : cache[nums[i] - 1];
        }
        return result;
    }
}
