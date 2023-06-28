package com.duomu.hj96;

import java.util.Scanner;

/**
 * 题目描述
 * 将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 * public static String MarkNum(String pInStr)
 * {
 *
 * return null;
 * }
 * 注意：输入数据可能有多行
 * 输入描述:
 * 输入一个字符串
 *
 * 输出描述:
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 *
 * 示例1
 * 输入
 * Jkdi234klowe90a3
 * 输出
 * Jkdi*234*klowe*90*a*3*
 */
public class

Main {
    /*思路：只要是数字，就两边都拼上*，然后把**去掉，肯定是数字之间的内容
      备注：Character.isDigit 判断一个字符是否是数字，Character.isLetter
      判断一个字符是否是字母
    */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(MarkNum(line));
        }
    }

    private static String MarkNum(String pInStr){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<pInStr.length();i++){
            if(Character.isDigit(pInStr.charAt(i))){
                sb.append("*").append(pInStr.charAt(i)).append("*");
            }else{
                sb.append(pInStr.charAt(i));
            }
        }
        return sb.toString().replace("**","");
    }
}
