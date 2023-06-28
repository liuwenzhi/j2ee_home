package lkhwtk.leetcode650;

/**
 * 650. 只有两个键的键盘
 * 参考题解：官方
 * 本题官方题解9月10号之后更新了
 * 这个算法是对Solution的另一种表示，效率和Solution基本一致
 */
public class Solution2 {
    public int minSteps(int n) {
        //dp[i] 表示打印出 i 个A 的最少操作次数，显而易见，dp[0]=0,dp[1]=0
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++)
        {
            //每一个dp[i]最大值为i，即拷贝一次，粘贴i-1次
            dp[i] = i;
            for (int j = 2; j * j <= i; j++)
            {
                if (i % j == 0) {
                    //Solution题解中：拷贝一次，粘贴 i/j-1次正好是dp[i/j]，拷贝一次，粘贴j-1次，正好是dp[j]，直接一个式子搞定
                    dp[i] = dp[j] + dp[i / j];
                }
            }
        }
        return dp[n];
    }
}
