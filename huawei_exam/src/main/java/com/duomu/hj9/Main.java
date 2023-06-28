package com.duomu.hj9;

import java.util.Scanner;

/**
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 9876673
 * 输出
 * 37689
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String temp = "";
        while(num>0){
            if(!temp.contains(num%10+"")){
                System.out.print(num%10);
                temp += num%10;
            }
            num /= 10;
        }
    }
}
