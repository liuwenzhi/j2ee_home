package lkhwtk.leetcode264;

/**
 * 参考题解：官方
 * 思路和solution一致，都是采用动态规划，这个效率能稍微高一点
 * 相对于313题，本题能够确认质因子，不用遍历数组，直接拿来计算就行
 * dp[i] 表示第 i 个丑数，第 n 个丑数即为 dp[n]，通过2,3,5三个质数，每次找距离i最近的那个丑数
 * 备注：题干说明有点问题，丑数 就是只包含质因数 2、3 或 5 的正整数。
 */
public class Solution {
    public int nthUglyNumber(int n) {
        //dp[0]不管，直接从dp[1]推到dp[n]
        int[] dp = new int[n + 1];
        dp[1] = 1;
        //p2 p3 p5初始化为1，后边用到了2 3 5哪个值，哪个值自增
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            //这里用了三个if，其实是去重的操作，可能这个dp[i]同时等于了多个num，对应指针都要累加，避免重复的值出现在下一个规划的结果中
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

}
