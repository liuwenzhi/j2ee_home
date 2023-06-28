package com.duomu.hj100;

import java.util.Scanner;

/**
 * 题目描述
 * 功能:等差数列 2，5，8，11，14。。。。
 *
 * 输入:正整数N >0
 *
 * 输出:求等差数列前N项和
 *
 * 返回:转换成功返回 0 ,非法输入与异常返回-1
 *
 * 本题为多组输入，请使用while(cin>>)等形式读取数据
 *
 * 输入描述:
 * 输入一个正整数。
 *
 * 输出描述:
 * 输出一个相加后的整数。
 *
 * 示例1
 * 输入
 *
 * 2
 * 输出
 *
 * 7
 */
public class Main {
    private static int sum(int n){
        int temp = 2;
        int result = 2;
        while(n>1){
            temp +=3;
            result += temp;
            n--;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            System.out.println(sum(scanner.nextInt()));
        }
    }
}