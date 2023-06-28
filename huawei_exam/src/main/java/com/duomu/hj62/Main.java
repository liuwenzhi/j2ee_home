package com.duomu.hj62;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 请实现如下接口
 *
 * public static int findNumberOf1( int num)
 *
 * {
         *return 0;
         *
         *}譬如：输入5 ，5的二进制为101，输出2
         *
         *
         *涉及知识点：
         *
         *注意多组输入输出！！！！！！
         *输入描述:
         *输入一个整数
         *
         *输出描述:
         *计算整数二进制中1的个数
         *
         *示例1
         *输入
         *5
         *输出
         *2
 */
public class Main {
    /**
     * 本题和15题类比下
     */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            int num = Integer.parseInt(line);
            System.out.println(findNumberOf1(num));
        }
    }

    private static int findNumberOf1(int num){
        int result = 0;
        String s = Integer.toBinaryString(num);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                result++;
            }
        }
        return result;
    }
}

