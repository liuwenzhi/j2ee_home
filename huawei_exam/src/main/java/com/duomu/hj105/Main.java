package com.duomu.hj105;

import java.util.Scanner;

/**
 * 题目描述
 * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
 * 数据范围小于1e6
 * 输入描述:
 * 输入任意个整数
 *
 * 输出描述:
 * 输出负数个数以及所有非负数的平均值
 *
 * 示例1
 * 输入
 * -13
 * -4
 * -7
 * 输出
 * 3
 * 0.0
 */
public class Main {
    /**
     * 本题说法存在问题，实际只有一组数据多个输入，不存在多组数据的情况，相对于97题，本题实际是没有输入数字总量限制，就随便输入一组数字
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //负数个数
        int num1 = 0;
        //非负数个数
        int num2 = 0;
        //所有非负数值总和
        int total = 0;
        while(scanner.hasNext()){
            int k = scanner.nextInt();
            if(k < 0){
                num1++;
            }else{
                num2++;
                total+=k;
            }
        }
        System.out.println(num1);
        System.out.printf("%.1f\n",num2==0?0:(total * 1.0 / num2));
        scanner.close();
    }
}
