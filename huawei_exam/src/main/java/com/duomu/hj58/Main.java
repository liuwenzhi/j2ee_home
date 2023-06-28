package com.duomu.hj58;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 输入n个整数，输出其中最小的k个。
 *
 * 详细描述：
 *
 * 接口说明
 *
 * 原型：
 *
 * bool GetMinK(unsignedint uiInputNum, int * pInputArray, unsignedint uiK, int * pOutputArray);
 *
 * 输入参数：
 *
 * unsignedint uiInputNum //输入整数个数
 *
 * int * pInputArray  //输入整数数组
 *
 * unsignedint uiK   //需输出uiK个整数
 *
 * 输出参数（指针指向的内存区域保证有效）：
 *
 * int * pOutputArray //最小的uiK个整数
 *
 * 返回值：
 *
 * false 异常失败
 *
 * true  输出成功
 * 本题有多组输入样例，请使用while(cin>>)等方式处理
 *
 *
 * 输入描述:
 * 输入说明
 * 1 输入两个整数
 * 2 输入一个整数数组
 *
 * 输出描述:
 * 输出一个整数数组
 *
 * 示例1
 * 输入
 * 5 2
 * 1 3 5 7 2
 * 输出
 * 1 2
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line1 = scanner.nextLine();
            int n = Integer.parseInt(line1.split("\\s+")[0]);
            int k = Integer.parseInt(line1.split("\\s+")[1]);
            String line2 = scanner.nextLine();
            String temp[] = line2.split("\\s+");
            int cache[] = new int[temp.length];
            for(int i=0;i<temp.length;i++){
                cache[i]=Integer.parseInt(temp[i]);
            }
            Arrays.sort(cache);
            for(int i=0;i<k;i++){
                System.out.print(cache[i]+" ");
            }
            //备注：这个换行非常重要，没有就不通过
            System.out.println();
        }
        scanner.close();
    }
}
