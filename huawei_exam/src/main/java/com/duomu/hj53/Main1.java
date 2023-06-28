package com.duomu.hj53;

import java.util.Scanner;

public class Main1 {
    public static int getFirstPlaceEven(int n){
        //采用动态规划方式构建一个三角形，构建方式比较有特点
        //
        int[][] map = new int[n + 1][2*n];
        map[1][1] = 1;
        for(int i = 2; i <= n; i++){
            map[i][1] = 1;
            for(int j = 2; j <= 2 * i - 1; j++)
                map[i][j] = map[i - 1][j - 1] + map[i - 1][j - 2] + map[i - 1][j];
        }
        //构建好之后找到第n行第一个偶数的位置，注意要从第一位开始，因为0位是0，就是偶数了
        for(int i = 1; i <= n; i++)
            if(map[n][i] % 2 == 0)
                return i;
        return -1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int firstEven = getFirstPlaceEven(n);
            System.out.println(firstEven);
        }
    }
}
