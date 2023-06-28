package lkhwtk.mst0811;

/**
 * 官方代码，核心思路和Solution一致，最核心内容是状态转移方程的简历
 * dp[i] = dp[i]+dp[i-coin]，同时注意不要出现硬币重复选择的情况
 * 单独定义dp[0]=1
 */
public class Solution1 {
    static final int MOD = 1000000007;
    int[] coins = {25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % MOD;
            }
        }
        return f[n];
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        solution1.waysToChange(6);
    }

}
