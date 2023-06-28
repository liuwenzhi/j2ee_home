package com.duomu.hj11;

import java.util.Scanner;

/**
 * 题目描述
 * 描述：
 *
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 *
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 复制
 * 1516000
 * 输出
 * 复制
 * 0006151
 */
public class Main {
    //采用数值计算取余方式实现
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        StringBuilder stringBuilder = new StringBuilder();
        //整体不考虑负数，负数直接过掉
        while(num > 0){
            stringBuilder.append(num % 10);
            num = num /10;
        }
        System.out.println(stringBuilder.toString());
    }
}
