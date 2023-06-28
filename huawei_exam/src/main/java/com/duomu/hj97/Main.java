package com.duomu.hj97;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 题目描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 *
 * 输入描述:
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 *
 * 输出描述:
 * 输出负数的个数，和所有正整数的平均值。
 *
 * 示例1
 * 输入
 * 5
 * 1
 * 2
 * 3
 * 4
 * 5
 * 输出
 * 0 3.0
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        while(scanner.hasNext()){
            //元素个数
            int n = scanner.nextInt();
            //负数个数
            int num1 = 0;
            //正整数个数
            int num2 = 0;
            //正整数累加和
            double total = 0;
            for(int i=0;i<n;i++){
                int k = scanner.nextInt();
                if(k<0){
                    num1++;
                }
                if(k>0){
                    num2++;
                    total+=k;
                }
            }
            System.out.println(num1+" "+decimalFormat.format(total/num2));
        }
        scanner.close();
    }
}
