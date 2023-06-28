package lkhwtk.offer47;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 参考题解：官方，核心一个点：找局部最优解。
 */
public class Solution {
    public int maxValue(int[][] grid) {
        //没有单独建立动态规划数组，直接通过原有的grid数组进行改变
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                if(i == 0) {
                    grid[i][j] += grid[i][j - 1] ;
                }
                else if(j == 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
