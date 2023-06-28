package lkhwtk.leetcode63;

/**
 * 63. 不同路径 II
 * 直接参考62题进行改就行，本题的官方题解代码中就把m和n弄反了，和例题是反的
 * 注意本题和面试题0802的区别，本题是路径数量，面试题0802需要把路径打出来，那个需要使用递归回溯来做
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //先把边界都设置为1，注意for循环中的条件，要满足如果出现障碍，后边就都默认为0，不设置为1，
        //这里容易发现不了，for条件是并且，一旦不满足这个条件，for循环就退出了，不要乱，就是有了障碍之后，后边就都不管了
        for (int i = 0; i < m && obstacleGrid[i][0]==0; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j]==0; ++j) {
            dp[0][j] = 1;
        }
        //基于状态转移方程：f(i,j)=f(i−1,j)+f(i,j−1) 去计算规划
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                //没有
                if(obstacleGrid[i][j]==0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];

    }
}
