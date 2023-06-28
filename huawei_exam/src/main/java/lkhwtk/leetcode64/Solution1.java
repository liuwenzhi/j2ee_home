package lkhwtk.leetcode64;

/**
 * 参考题解：官方
 * 从前往后推
 */
public class Solution1 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        //左上角dp[0][0]值为grid[0][0]
        dp[0][0] = grid[0][0];
        //初始化第一列：除了最左上角的元素，dp[i][0]只能从dp[i-1][0]规划过来
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //初始化第一行：除了最左上角的元素，dp[0][j]只能从dp[0][j-1]规划过来
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //不在第一行，也不在第一列，找到左边或者上边的最小值+节点值作为最小规划值
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
