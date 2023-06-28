package com.duomu.hj81;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述
 * 题目标题：
 *
 * 判断短字符串中的所有字符是否在长字符串中全部出现
 *
 * 详细描述：
 *
 * 接口说明
 *
 * 原型：
 *
 * boolIsAllCharExist(char* pShortString,char* pLongString);
 *
 * 输入参数：
 *
 *     char* pShortString：短字符串
 *     char* pLongString：长字符串
 * 输入描述:
 * 输入两个字符串。第一个为短字符，第二个为长字符。
 *
 * 输出描述:
 * 返回值：
 *
 * 示例1
 * 输入
 * bc
 * abc
 * 输出
 * true
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String shortStr = scanner.nextLine();
            String longStr = scanner.nextLine();
            System.out.println(containsStr(shortStr,longStr));
        }
        scanner.close();
    }

    /**
     * 判断短字符串中的字符是否都在长字符串中出现
     * 注意：短字符串在长字符串中出现的方式可能不是连续的，或者只有部分连续
     */
    private static boolean containsStr(String shortStr,String longStr){
        boolean result = true;
        Set<Character> set = new HashSet<>(longStr.length());
        for(int i=0;i<longStr.length();i++){
            set.add(longStr.charAt(i));
        }
        for(int i=0;i<shortStr.length();i++){
            if(!set.contains(shortStr.charAt(i))){
                result = false;
                break;
            }
        }
        return result;
    }
}
