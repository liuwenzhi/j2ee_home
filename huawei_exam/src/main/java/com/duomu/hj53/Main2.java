package com.duomu.hj53;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 个人思路构建一个完整的动态规划数组
 */
public class Main2 {
    public static int getFirstPlaceEven(int n){
        //采用动态规划方式构建一个三角形，构建方式比较有特点
        /*
        *   0 1 0 0 0 0
        *   0 1 1 1 0 0
        *   0 1 2 3 2 1 0 0
        *   0 1 3 6 7 6 3 1
        *   每一行的元素，头两个被定义好，从第三元素个开始规划，第三个元素等于上一行同列元素+上一行前一列元素+上一行前两列元素
        */
        int[][] dp = new int[n][2*n];
        dp[0][1] = 1;
        for(int i = 1; i < n; i++){
            dp[i][1] = 1;
            //实际构建数组的过程中，因为每行数据的对称性，不用都构建完2n个元素，只构建前n个，这里需要注意保证必要统计的完整性
            for(int j = 2; j <n; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j - 2] + dp[i - 1][j];
            }
        }
        //构建好之后找到第n行第一个偶数的位置，注意从1开始，0是自己建的0
        for(int i = 1; i < n; i++)
            if(dp[n-1][i] % 2 == 0)
                return i;
        return -1;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int n = Integer.parseInt(line);
            int firstEven = getFirstPlaceEven(n);
            System.out.println(firstEven);
        }
    }
}
