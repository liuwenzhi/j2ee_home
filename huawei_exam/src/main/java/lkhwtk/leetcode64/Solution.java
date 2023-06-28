package lkhwtk.leetcode64;

/**
 * 64. 最小路径和
 * 注意：本题可以用搜索，但是时间复杂度比较高，在数据量比较小的情况下，比如46题的情况适合，
 * 数据量大的情况下，最适合还是使用动态规划。注意：本题采用动态规划的时候，也是从后往前推，
 * 和之前回溯剪枝类似。
 * 参考题解：官方视频
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int i = row-1;i>=0;i--){
            for(int j = col-1;j>=0;j--){
                if(i!=row-1&&j!=col-1){
                    //如果点不是在二维数组的右边界或者下边界上
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
                }else if(i==row-1&&j!=col-1){
                    //点在下边界，不在右边界上
                    dp[i][j] = dp[i][j+1]+grid[i][j];
                }else if(i!=row-1&&j==col-1){
                    //点在右边界，不在下边界上
                    dp[i][j] = dp[i+1][j]+grid[i][j];
                }else{
                    //既在右边界，右在下边界，即：最右下角这个点，dp值是原值，相当于本题算法的起点值
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new Solution().minPathSum(a));
    }
}
