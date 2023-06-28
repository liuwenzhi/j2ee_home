package com.duomu.hj91;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    /*f(n,m)表示n*m矩阵的走法，第一步可以往下走，走了之后矩阵变成(n-1)*m，也可以往右走，
    矩阵就变成n*(m-1)，所以f(n,m)=f(n-1,m)+f(n,m-1)，明显的递归式。*/
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            String[] temp = line.split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            System.out.println(func(n,m));
        }
    }
    /*采用动态规划求解*/
    private static int func(int row,int col){
        int[][] dp = new int[row+1][col+1];
        dp[0][0] = 1;
        //第一列每个元素都初始化为1，只有一条路径过来
        for(int i=1;i<=row;i++){
            dp[i][0] = 1;
        }
        //第一行每个元素都初始化为1，只有一条路径走过来
        for(int i=1;i<=col;i++){
            dp[0][i] = 1;
        }
        //除了第一行和第一列，其他元素可以从左边或者上边元素规划过来
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[row][col];
    }
}
