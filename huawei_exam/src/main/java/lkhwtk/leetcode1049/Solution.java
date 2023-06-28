package lkhwtk.leetcode1049;

import java.util.Arrays;

/**
 * 1049. 最后一块石头的重量 II
 * 参考题解：官方，建立二维动态规划数组
 */
public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        //用下边这种流的方式统计和会比上边遍历统计慢1到2ms
        //int sum = Arrays.stream(stones).sum();
        int n = stones.length, m = sum / 2;
        //遍历boolean动态规划数组，前n个元素能不能凑出0到m重量
        boolean[][] dp = new boolean[n + 1][m + 1];
        //dp[0][0]
        dp[0][0] = true;
        //内层状态转移公式通过dp[i+1]来计算，所以外层循环使用i<n，第0行没必要初始化，0个元素无论如何凑不出非0元素，只有dp[0][0]=true
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (j < stones[i]) {
                    //j小于stones[i]，肯定不能选择stones[i]，dp值等同于同列上一行值
                    dp[i + 1][j] = dp[i][j];
                } else {
                    //如果j大于stones[i]，有两种选择，可以选择stones[i]也可以不选择，不选择就是dp[i][j]，选择就要找到j-stones[i]是否正确
                    dp[i + 1][j] = dp[i][j] || dp[i][j - stones[i]];
                }
            }
        }
        //规划的最后一行肯定存在一个最小值，所以最后的for循环也不设一个条件了，
        //在这种情况下，可以直接编译通过，如果设置了条件，就必须在for循环外边单独做一个返回值
        for (int j = m;; --j) {
            //用n个石头能凑出最大的j能凑出满足条件的最小的石头
            if (dp[n][j]) {
                return sum - 2 * j;
            }
        }
    }
}
