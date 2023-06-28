package com.duomu.hj56;

import java.util.Scanner;

/**
 * 题目描述
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 *
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 *
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 *
 * 给定函数count(int n),用于计算n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
 *
 * 返回n以内完全数的个数。 异常情况返回-1

 *  *  完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 *
 *  *  它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 *
 *  *  例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 *
 *  *
 *
 *  *  给定函数count(int n),用于计算n以内(含n)完全数的个数
 *
 *  * @param n  计算范围, 0 < n <= 500000
 *
 *  * @return n 以内完全数的个数, 异常情况返回-1
 *public static   int count(int n)
        *输入描述:
        *输入一个数字
        *
        *输出描述:
        *输出完全数的个数
        *
        *示例1
        *输入
        *1000
        *输出
        *3
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            System.out.println(count(n));
        }
        scanner.close();
    }

    private static int count(int n){
        //result记录累计数量
        int result = 0;
        int temp = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                if(i%j==0){
                    temp+=j;
                }
            }
            if(temp==i){
                result ++;
                //测试看下这个数字是多少，6,28,496
                //System.out.println(temp);
            }
            //每次temp重新计数，作为一个临时的累加变量
            temp = 0;
        }
        return result;
    }
}
