package lkhwtk.leetcode516;

/**
 * 516. 最长回文子序列
 * 备注：子串与子序列区别：子串不可跳跃，子序列可以跳跃，如 “AC”是“ABCDEFG”的子序列，而不是子串。 而“ABC”则是其子串（这一点整理到公共部分）
 * 同时注意本题和409题的区别，409题可以随机改变字母的顺序，本题必须按照原来的顺序不能改变
 * 子序列问题本身就相对子串、子数组更困难一些，因为前者是不连续的序列（子序列可以跳着组成），而后两者是连续的，可以比对下hj85
 * 结题参考：动态规划，四要素
 * 具体图解可以参考题解：「代码随想录」带你学透DP子序列问题！516. 最长回文子序列【动态规划】详解
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            //初始化f[i][i]= 1，单个字符直接是一个回文字符串
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }
}
