package lkhwtk.leetcode560;

/**
 * 参考题解：官方
 * Solution方案中，按照正序遍历i和j需要单独考虑一些情况，如果是正着访问i，逆着访问j
 * 就会容易很多，不需要单独考虑一些情况，但实际效率和Solution差不多。
 */
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //外层for循环正序
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            //内层for循环逆序，这样就不用单独考虑边界等一些特殊处理IQ那个卡UN个
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
