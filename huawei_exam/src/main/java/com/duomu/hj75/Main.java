package com.duomu.hj75;

import java.util.Scanner;

/**
 * 题目描述
 * 题目标题：
 *
 * 计算两个字符串的最大公共字串的长度，字符不区分大小写
 *
 * 详细描述：
 *
 * 接口说明
 *
 * 原型：
 *
 * int getCommonStrLength(char * pFirstStr, char * pSecondStr);
 *
 * 输入参数：
 *      char * pFirstStr //第一个字符串
 *
 *      char * pSecondStr//第二个字符串
 * 输入描述:
 * 输入两个字符串
 *
 * 输出描述:
 * 输出一个整数
 *
 * 示例1
 * 输入
 * asdfas
 * werasdfaswer
 * 输出
 * 6
 */
public class Main {
    /*思路：本题和65题思路类似*/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            if(line1.length()>=line2.length()){
                System.out.println(getCommonLength(line1,line2));
            }else{
                System.out.println(getCommonLength(line2,line1));
            }
        }
    }

    /**
     * @param line1 长的串
     * @param line2 短的串
     */
    private static int getCommonLength(String line1,String line2){
        int max = 0;
        //从头往后遍历短的，提取子串
        for(int i=0;i<line2.length();i++){
            for(int j=line2.length();j>i;j--){
                //加一步不区分大小写
                if(line1.toLowerCase().contains(line2.substring(i,j).toLowerCase())){
                    max = Math.max(max,line2.substring(i,j).length());
                }
            }
        }
        return max;
    }
}
