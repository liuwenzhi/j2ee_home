package com.duomu.hj52;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            String strA = line;
            String strB = br.readLine();
            //插入字符次数insert cost统计
            int ic = 1;
            //删除字符次数delete cost统计
            int dc = 1;
            //替换字符次数replace cost统计
            int rc = 1;
            int cost = strEditCost(strA, strB, ic, dc, rc);
            System.out.println(cost);
        }
    }
    public static int strEditCost(String strA, String strB, int ic, int dc, int rc){
        int m = strA.length();
        int n = strB.length();
        int[][] dp = new int[m + 1][n + 1];
        //构建的二维数组第一行赋值
        for (int i = 1; i <= n; i++) dp[0][i] = i*ic;
        //构建的二维数组第一列赋值
        for (int i = 1; i <= m; i++) dp[i][0] = i*dc;
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                int cost1 = dp[x-1][y] + dc;
                int cost2 = dp[x][y-1] + ic;
                int cost3 = 0;
                if(strA.charAt(x-1) == strB.charAt(y-1)) {
                    cost3 = dp[x - 1][y - 1];
                } else {
                    cost3 = dp[x - 1][y - 1] + rc;
                }
                dp[x][y] = Math.min(cost1, cost2);
                dp[x][y] = Math.min(dp[x][y], cost3);
            }
        }
        return dp[m][n];
    }
}
