package lkhwtk.mst0811;

/**
 * 面试题 08.11. 硬币
 * 参考题解：
 * 接地气讲解（动态规划，完全背包问题）
 * 核心思路：dp方程：dp[i] += dp[i - coin];
 * 官方题解说明过于繁琐，可以看下官方的代码
 * 这个题解：背包，个人意见，大家分享，对于一些基本内容说的还行，但是相对于本题内容说的过于复杂
 */
public class Solution {
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1,5,10,25};
        //定义dp[0]=1方便后边计算，算法核心：dp[i] = (dp[i] + dp[i - coin])，当i=coin，dp[i]=dp[i]+dp[0],正好累加1
        dp[0] = 1;
        //注意：一定是外层遍历硬币，不然会出现重复计算的情况，比如6出现1+5和5+1的情况
        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.waysToChange(6);
    }
}
