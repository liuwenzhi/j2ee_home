package com.duomu.hj65;
import java.util.Scanner;

/**
 * 题目描述
 * 查找两个字符串a,b中的
 * 最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 输入描述:
 * 输入两个字符串
 * 输出描述:
 * 返回重复出现的字符
 * 示例1
 * 输入
 * 复制
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出
 * 复制
 * jklmnop
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            //字符串的长短根据输入单独确认下
            if(line1.length()>=line2.length()){
                System.out.println(getCommonStr(line1,line2));
            }else{
                System.out.println(getCommonStr(line2,line1));
            }
        }
    }

    /**
     * @param line1 长的串
     * @param line2 短的串
     */
    private static String getCommonStr(String line1,String line2){
        String common = "";
        //从头往后遍历短的，提取子串，外层for循环找短字符串的左边界，内层for循环找短字符串的右边界
        for(int i=0;i<line2.length();i++){
            for(int j=line2.length();j>i;j--){
                //如果长的包含短的，子串，则满足公共字符串条件，再进行长度判断
                if(line1.contains(line2.substring(i,j))){
                    //只在common比公共子串长度短的时候进行替换
                    if(common.length()<line2.substring(i,j).length()){
                        common = line2.substring(i,j);
                    }
                }
            }
        }
        return common;
    }
}
