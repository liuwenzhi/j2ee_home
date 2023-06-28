package lkhwtk.leetcode673;

import java.util.Arrays;

/**
 * 其他参考答案：动态规划解最长子序列子串等一类问题之最长连续递增序列[Reindeer]
 * 核心思路和Solution一致，统计结果的时候稍微简化，时空复杂度和Solution相差不大
 */
public class Solution1 {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int[] counter = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(counter, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        counter[i] = counter[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counter[i] += counter[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) res += counter[i];
        }
        return res;
    }

}
