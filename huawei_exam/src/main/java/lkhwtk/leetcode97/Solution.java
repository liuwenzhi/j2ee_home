package lkhwtk.leetcode97;

/**
 * 97. 交错字符串
 * 类似路径问题，找准状态方程快速求解（这个题解说明挺好，代码初始化部分有问题）
 * 第一行、第一列初始化方式非常好，能够提升官方代码效率一倍
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) return false;
        //动态规划，dp[i,j]表示s1前i字符能与s2前j字符组成s3前i+j个字符；
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        //初始化第一列，不相符直接终止
        for (int i = 1; i <= m && s1.charAt(i-1) == s3.charAt(i-1); i++) {
            dp[i][0] = true;
        }
        //初始化第一行，不相符直接终止
        for (int j = 1; j <= n && s2.charAt(j-1) == s3.charAt(j-1); j++) {
            dp[0][j] = true;
        }
        //在一个二维数组中，只能往右下走的情况下，去找匹配的单词
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //从左边规划过来或者从上边规划过来
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        Solution solution1 = new Solution();
        solution1.isInterleave("bacc","aabcce","abaacbccec");
    }
}
