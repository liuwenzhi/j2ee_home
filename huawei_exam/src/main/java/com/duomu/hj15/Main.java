package com.duomu.hj15;

import java.util.Scanner;

/**
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入
 * 5
 * 输出
 * 2
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char[] c = Integer.toBinaryString(scanner.nextInt()).toCharArray();
        int num = 0;
        for(int i=0;i<c.length;i++){
            if("1".equals(c[i]+"")){
                num++;
            }
        }
        System.out.println(num);
    }
}
