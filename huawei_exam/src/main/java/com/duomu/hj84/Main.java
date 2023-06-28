package com.duomu.hj84;

import java.util.Scanner;

/**
 * 题目描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数
 *
 * 接口说明
 *
 * 原型：int CalcCapital(String str);
 *
 * 返回值：int
 *
 *
 *
 * 输入描述:
 * 输入一个String数据
 *
 * 输出描述:
 * 输出string中大写字母的个数
 *
 * 示例1
 * 输入
 * 复制
 * add123#$%#%#O
 * 输出
 * 复制
 * 1
 */
public class Main {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                //直接通过Character判断是否是大写字母
                if (Character.isUpperCase(c)) {
                    num++;
                }
            }
            System.out.println(num);
        }
    }
}
