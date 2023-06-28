package lkhwtk.leetcode647;

/**
 * 647. 回文子串
 * 题解参考：两道回文子串的解法（详解中心扩展法）
 */
public class Solution1 {
    /*动态规划法：状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
    *状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false*/
    public int countSubstrings(String s) {
        int result = 0;
        //初始化二维动态规划数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        //注意二维动态规划数组的遍历方式：列在外层，行在内层，避免按行遍历时dp[i]访问没有实际初始化的dp[i+1]
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<2||dp[i+1][j-1])){
                    dp[i][j] = true;
                    result ++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        boolean[] a = new boolean[5];
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }


    }
}
