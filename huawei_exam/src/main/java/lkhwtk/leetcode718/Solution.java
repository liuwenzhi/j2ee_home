package lkhwtk.leetcode718;

/**
 * 参考题解：官方动态规划
 * A[i:] 表示数组 A 中索引 i 到数组末尾的范围对应的子数组。
 * B[j:] 表示数组 B 中索引 j 到数组末尾的范围对应的子数组。
 * dp[i][j]表示A[i:]和B[j:]最长公共子数组长度，然后基于最长公共前缀的思路来构建动态规划方程
 * 状态转移方程为：如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0
 * 沿着这个思路往下走，动态规划需要倒着来，注意：本题的规划不论是dp[0][0]还是dp[m][n]都不是最终结果，最
 * 终结果大概率在规划的二维数组中，定义一个max变量来记录
 */
public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m= nums1.length,n=nums2.length;
        //本算法中第m行和第n列上的元素全为0，在计算状态转移方程的过程中，起到了辅助作用
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(nums1[i]==nums2[j]){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
