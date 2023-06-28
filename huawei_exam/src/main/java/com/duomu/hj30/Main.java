package com.duomu.hj30;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * 题目描述
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 *
 * 将输入的两个字符串合并。
 *
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 *
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 *
 *
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
 *
 * 注意本题含有多组样例输入
 *
 *
 * 输入描述:
 * 本题含有多组样例输入。每组样例输入两个字符串，用空格隔开。
 *
 * 输出描述:
 * 输出转化后的结果。每组样例输出一行。
 *
 * 示例1
 * 输入
 * 复制
 * dec fab
 * 输出
 * 复制
 * 5D37BF
 */
public class Main{
    public static void main(String[] str){
        processStr();
    }

    public static void processStr(){
        //hash 保存十六进制反转的对应表， 空间换时间
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put('0', '0');
            put('1', '8');
            put('2', '4');
            put('3', 'C');
            put('4', '2');
            put('5', 'A');
            put('6', '6');
            put('7', 'E');
            put('8', '1');
            put('9', '9');
            put('a', '5');
            put('b', 'D');
            put('c', '3');
            put('d', 'B');
            put('e', '7');
            put('f', 'F');
            put('A', '5');
            put('B', 'D');
            put('C', '3');
            put('D', 'B');
            put('E', '7');
            put('F', 'F');
        }};

        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            char[] ch = (s1 + s2).toCharArray();
            //下标奇数位，下标位从0开始算，奇数位等于偶数位或者奇数位比偶数位少1
            char[]r1 = new char[ch.length / 2];
            //下标偶数位，下标位从0开始算
            char[]r2 = new char[ch.length - ch.length / 2];
            for (int i = 0, j = 0, k = 0; i < ch.length; i++){
                if ( i % 2 == 0){
                    r2[j] = ch[i];
                    j++;
                }else {
                    r1[k] = ch[i];
                    k++;
                }
            }
            Arrays.sort(r1);
            Arrays.sort(r2);
            for (int i = 0, j = 0, k = 0; i < ch.length; i++){
                if (i % 2 == 0){
                    //注意存在码表不包含的情况，使用原值
                    ch[i] = map.getOrDefault(r2[j], r2[j]);
                    j++;
                }else {
                    ch[i] = map.getOrDefault(r1[k], r1[k]);
                    k++;
                }
            }

            s = new String(ch);
            System.out.println(s);

        }

        //return s;
    }

}