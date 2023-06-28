package com.duomu.hj53;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 1
 * 1  1  1
 * 1  2  3  2  1
 * 1  3  6  7  6  3  1
 * 1  4  10 16 19  16 10  4  1
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 *
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 *
 * 输入n(n <= 1000000000)
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)等方式读入
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 输出返回的int值
 *
 * 示例1
 * 输入
 * 4
 * 输出
 * 3
 */
public class Main {
    /*核心思路： 本题偏重技巧
        if n<=2:
            res=-1
        elif n%2==1:
            res=2
        elif n%4==0:
            res=3
        else:
            res=4
        print(res)
    */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int n = Integer.parseInt(line);
            if(n<=2){
                System.out.println(-1);
            }else if(n%2==1){
                System.out.println(2);
            }else if(n%4==0){
                System.out.println(3);
            }else{
                System.out.println(4);
            }
        }
    }
}
