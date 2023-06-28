package com.duomu.hj92;

import java.util.*;

/**
 * 题目描述
 * 样例输出
 *
 * 输出123058789，函数返回值9
 *
 * 输出54761，函数返回值5
 *
 *
 *
 * 接口说明
 *
 * 函数原型：
 *
 *    unsignedint Continumax(char** pOutputstr,  char* intputstr)
 *
 * 输入参数：
 *    char* intputstr  输入字符串；
 *
 * 输出参数：
 *    char** pOutputstr: 连续最长的数字串，如果连续最长的数字串的长度为0，应该返回空字符串；如果输入字符串是空，也应该返回空字符串；
 *
 * 返回值：
 *   连续最长的数字串的长度
 * 输入描述:
 * 输入一个字符串。
 *
 * 输出描述:
 * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不间隔），但是长度还是一串的长度，与数字字符串间用逗号间隔。
 *
 * 示例1
 * 输入
 * abcd12345ed125ss123058789
 * 输出
 * 123058789,9
 */
public class Main {
    /**
     * 思路：把数字串都截取出来，然后比较得出最长的数字串，最后长度直接按照截取出来的算即可，
     * 如果有长度一致的数字串，则直接一起输出
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println(getSubStrAndLength(line));
        }
    }
    private static String getSubStrAndLength(String line){
        Map<String,Integer> map = new LinkedHashMap<>();
        String temp = "";
        int max = 0;
        for(int i=0;i<line.length();i++){
            if(Character.isDigit(line.charAt(i))){
                temp+=line.charAt(i);
            }else{
                //不是数字字符，但是已经拼接到temp的情况
                if(!"".equals(temp)){
                    map.put(temp,temp.length());
                    if(temp.length() > max){
                        max = temp.length();
                    }
                    temp = "";
                }
            }
        }
        //不是数字字符，但是已经拼接到temp的情况，补一下最后一次的统计
        if(!"".equals(temp)){
            map.put(temp,temp.length());
            if(temp.length() > max){
                max = temp.length();
            }
        }
        final int max1 = max;
        //长度相等的数字字符串直接拼
        StringBuilder sb = new StringBuilder("");
        map.forEach((key,value)->{
            if(value == max1){
                sb.append(key);
            }
        });
        //数字字符串拼完了之后拼一个逗号，拼最大长度
        sb.append(",").append(max1);
        return sb.toString();
    }
}
