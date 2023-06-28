package com.duomu.hj5;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 */
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            //decode方法能将给定格式的十进制，十六进制，八进制字符串转成十进制数字，十六进制和八进制字符串需要有固定的格式，参考原码注释说明
            System.out.println(Integer.decode(str));
        }
    }
}
