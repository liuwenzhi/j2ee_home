package com.duomu.hj2;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入
 * ABCDEF
 * A
 * 输出
 * 1
 * 注意：替换字符串不区分大小写
 * 本题通过率低的主要原因是第二个入参是一个字符，不是一个字符串
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //从客户端接收第一行：字母和数字组成字符串
        String wordAndNum = scanner.nextLine();
        //从客户端接收第二行字符
        char character = scanner.next().toCharArray()[0];
        //获取到字符对应的大写或者小写形式
        char character1 = Character.isUpperCase(character)?Character.toLowerCase(character):Character.toUpperCase(character);
        scanner.close();
        //计算原始字符串长度
        int length = wordAndNum.length();
        //将原始字符串中输入字符和对应的大写或者小写字符替换成空字符，再计算一次长度
        int newLength = wordAndNum.replace(String.valueOf(character),"").replace(String.valueOf(character1),"").length();
        System.out.println(length-newLength);
    }
}