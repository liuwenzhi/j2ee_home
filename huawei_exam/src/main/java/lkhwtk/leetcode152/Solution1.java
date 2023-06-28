package lkhwtk.leetcode152;

/**
 * 对Solution的优化，核心算法中，每次只对max[i-1]和min[i-1]进行计算，单独有变量维护
 */
public class Solution1 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];
        //循环中每次比较maxF[i-1]*nums[i],minF[i-1]*nums[i],nums[i]
        for (int i = 1; i < length; ++i) {
            int maxLast = maxF;
            int minLast = minF;
            maxF = Math.max(maxLast * nums[i], Math.max(nums[i], minLast * nums[i]));
            minF = Math.min(minLast * nums[i], Math.min(nums[i], maxLast * nums[i]));
            ans = Math.max(maxF,ans);
        }
        return ans;
    }
}
