package lkhwtk.leetcode279;

/**
 * 279. 完全平方数
 * 参考题解：画解算法：279. 完全平方数 精选
 * 参考题解：官方。
 * 两个题解结合起来看，dp[i] 表示最少需要多少个数的平方来表示整数 i
 */
public class Solution {
    public int numSquares(int n) {
        // 默认初始化值都为0，dp[0]=0主要是满足状态转移方程中的设计，比如dp[4],j=2的情况下，dp[0]=0,正好加1结果为1
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            //dp[i]初始化为最大值，即最坏情况，由n个1组成的情况，3=1+1+1,4=1+1+1+1
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                //动态转移方程，j从1开始，在取到j之后，j算一个数字，看下i-j*j有几个组成情况，记为dp[i - j * j]，
                //然后再比较dp[i]当前最坏情况和dp[i - j * j] + 1的值哪个更小，这一步类似于0,1背包问题
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.numSquares(13);
    }

}
