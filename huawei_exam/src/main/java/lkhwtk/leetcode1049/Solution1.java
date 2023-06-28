package lkhwtk.leetcode1049;

/**
 * 由于01背包dp[i+1]只和dp[i]相关，可以将二维数组降为一维数组，
 * 降为1位数组之后，按照01背包，需要从后往前计算，因为后边的计算内容要用到前边，从前往后计算就会改变值
 * 参考题解：官方
 * 其他辅助参考题解：Java 01背包经典例题 二维+一维
 */
public class Solution1 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int weight : stones) {
            //注意：内层循环是j>=weight，直接找能放当前重量的石头的情况，对于<weight的情况保留原值不用变
            for (int j = m; j >= weight; --j) {
                //if (j >= weight) 本题这个判断条件可以不加，由于取或这种特殊性的算法
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int j = m;; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
}
