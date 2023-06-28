package lkhwtk.leetcode1143;

/**
 * 1143. 最长公共子序列
 * 参考583题完成此题，可以作为一个标准的模板背诵下
 * dp[i][j]代表text1的前i个元素和text2的前j个元素公共子序列的最大长度
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }
}
