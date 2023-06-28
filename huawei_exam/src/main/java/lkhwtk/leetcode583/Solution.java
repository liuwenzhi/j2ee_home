package lkhwtk.leetcode583;

/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * 注意：本题实际要找形成最长公共子序列（LCS）所需要的变化次数，包括这种:AaBbCcDd->abcd，第一个字符串删除ABCD之后变成第二个字符串，要保证顺序
 * 参考题解：【宫水三叶】从两种「序列 DP」角度进行求解
 * 底阿妈中求最常公公子序列的代码参考了1143题
 */
public class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        //dp[i][j]代表s1的前i个字符和s2的前j个字符形成最长公共子序列的长度
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if (i == 0 || j == 0){
                    continue;
                }
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    //这里要取最长公共子序列，所以肯定要找大的。
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        //最终返回m-dp[m][n]+n-dp[m][n]
        return m+n-2*dp[m][n];
    }
    public static void main(String[] args){
        System.out.println();
    }
}
