package lkhwtk.offer49;

/**
 * 剑指 Offer 49. 丑数
 * 直接抄264题思路，本题可以直接参考下这个题解：剑指 Offer 49. 丑数（动态规划，清晰图解）
 * 题解中Xn和a、b、c那个关系可以通过Xn+1和Xn的关系来进行推导
 */
public class Solution {
    public int nthUglyNumber(int n) {
        //dp[0]不管，从dp[1]推到dp[n]
        int[] dp = new int[n + 1];
        dp[1] = 1;
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
