package com.duomu.hj71;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 * ？：匹配1个字符
 *
 *
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 *
 *
 * 输出：
 * 返回匹配的结果，正确输出true，错误输出false
 *
 * 输入描述:
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 *
 * 输出描述:
 * 返回匹配的结果，正确输出true，错误输出false
 *
 * 示例1
 * 输入
 * te?t*.*
 * txt12.xls
 * 输出
 * false
 */
public class Main {
    /**
     * 2021年9月2日三轮刷题重新做，基于动态规划思路
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while((str=br.readLine())!=null){
            //str为带有通配符的字符串，转小写
            str=str.toLowerCase();
            //line为带匹配的字符串，转小写
            String line=br.readLine().toLowerCase();
            //建立动态规划数组，元素(i,j)代表str的前i个元素能否和line的前j个元素匹配上
            boolean [][] flag=new boolean[str.length()+1][line.length()+1];
            //动态规划二维数组最左上角元素设置为true，主要为了方便后边计算，通过设计逻辑来说，可以理解为str的前0个字符串和line的前0个字符串能匹配上
            flag[0][0]=true;
            //如果str以*开头，那么flag[1][0]为true，*可以匹配0个字符
            if(str.charAt(0)=='*'){
                flag[1][0]=true;
            }
            //外层循环是带有通配符字符串，内层循环是带有比较的字符串
            for(int i=1;i<=str.length();i++){
                char ch=str.charAt(i-1);
                for(int j=1;j<=line.length();j++){
                    char c=line.charAt(j-1);
                    if(ch=='?'){
                        if(check(c)){
                            //如果str当前字符是？，则直接看str的前i-1个元素和line的前j-1个元素能否匹配上（flag[i][j]看到是字符编号i-1和j-1的匹配，对应了前i个字符和j个字符）
                            flag[i][j]=flag[i-1][j-1];
                        }else{
                            //如果是·，匹配不上
                            flag[i][j]=false;
                        }
                    }else if(ch=='*'){
                        if(check(c)){
                            //如果str当前字符是*，则直接看i-1,j-1（一个*匹配1个字符）,或者i和j-1（一个*匹配0个字符）或者i-1和j（一个*能匹配多个字符）
                            flag[i][j]=flag[i-1][j-1]||flag[i][j-1]||flag[i-1][j];
                        }else{
                            flag[i][j]=false;
                        }
                    }else if(ch==c){
                        //字符相等的情况直接看前边的能否匹配上，这里的字符可能是字母、数字或者点
                        flag[i][j]=flag[i-1][j-1];
                    }else{
                        flag[i][j]=false;
                    }
                }
            }
            System.out.println(flag[str.length()][line.length()]);
        }
    }

    /**
     * 验证字符是字母和数字
     */
    public static boolean check(char ch){
        if(ch>='a'&&ch<='z'||ch>='0'&&ch<='9'){
            return true;
        }
        return false;
    }
}
