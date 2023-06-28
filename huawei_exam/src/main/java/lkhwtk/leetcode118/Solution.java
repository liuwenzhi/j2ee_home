package lkhwtk.leetcode118;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 个人动态规划思路
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        //构建一个动态规划二维数组，第一行一个1，其他都是0，从第二行开始通过状态转移方程进行累加
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        for(int i=1;i<numRows;i++){
            for(int j=0;j<numRows;j++){
                if(j==0||j==i){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                }
            }
        }
        for(int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>(i+1);
            for(int j=0;j<=i;j++){
                row.add(dp[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}
