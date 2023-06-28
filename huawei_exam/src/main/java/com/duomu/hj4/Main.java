package com.duomu.hj4;

import java.util.Scanner;

/**
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 */
public class Main {
    /*
    * 第一步：字符串整体补0，达到8的整数倍；
    * 第二步：做输出处理，输出中delete方法是亮点
    */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            StringBuffer sb=new StringBuffer(s);
            //如果s的长度不足8的倍数位，则用0补位
            if(s.length()%8!=0){
                int n=8-s.length()%8;
                for(int i=0;i<n;i++){
                    sb.append("0");
                }
            }
            //之前已经用0补位好，则直接按照8的倍数输出
            while(sb.length()>=8){
                System.out.println(sb.substring(0, 8));
                sb=sb.delete(0, 8);
            }
        }
    }
}
