package com.duomu.hj15;

import java.util.Scanner;

/**
 * 通过算法实现十进制数字到二进制数字的转换
 */
public class Main1 {
    public static void main(String[] arg){
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int i=31;i>=0;i--){
            //无符号右移，int类型一共占4个字节，左移31位开始一直到移动0位，从最高位到最低位都和1做一遍与计算
            sb.append((num>>>i)&1);
        }
        //拿到转换的二进制数字
        String line=sb.toString();
        //System.out.println(line);
        //转成二进制数字之后统计1的个数，通过替换1为空字符串，然后计算字符串和原始字符串长度差
        System.out.println(line.length()-line.replaceAll("1","").length());
    }

}
