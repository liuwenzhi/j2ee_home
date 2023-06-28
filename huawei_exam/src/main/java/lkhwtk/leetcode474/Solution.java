package lkhwtk.leetcode474;

/**
 * 474. 一和零
 * 参考题解：动态规划（转换为 0-1 背包问题）
 * 本题只要把三维动态规划数组思路构思明白就不难了，本题构建动态规划三维方程的核心想法是：前i个字符串（0到i-1）包含j个0和k个1的最大字符串个数，
 * 实际就是通过0-1背包，看当前字符串放还是不放的问题
 * 注意一个点：0,1背包大部分情况将dp数组长度设置为length+1
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            // 注意：有一位偏移，统计每一个字符串的0和1的个数，然后进行规划
            int[] count = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 先把上一行抄下来，这一步放到else里边能更好的优化一点
                    //dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = count[0];
                    int ones = count[1];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }else{
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    /**
     * 统计一个字符串中0和1的个数，返回一个1*2的数组，
     * 分别代表0的个数和1的个数
     */
    private int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

}
