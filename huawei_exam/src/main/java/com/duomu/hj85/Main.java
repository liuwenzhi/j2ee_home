package com.duomu.hj85;

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 * （注意：记得加上while处理多个测试用例）
 *
 * 输入描述:
 * 输入一个仅包含小写字母的字符串
 *
 * 输出描述:
 * 返回最长回文子串的长度
 *
 * 示例1
 * 输入
 * 复制
 * cdabbacc
 * 输出
 * 复制
 * 4
 * 说明
 * abba为最长的回文子串
 */
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println(palindrome(line));
        }
        scanner.close();
    }
    private static int palindrome(String str) {
        int len = str.length();
        int max = 1;
        for(int i = 1; i < len; i++){
            //回文数是偶数情况，每次循环都是相邻两个
            int low = i-1;
            int high = i;
            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
                low--;
                high++;
            }
            /*注意：这里为啥是high-low-1，因为此刻上边while循环结束之后，low比实际回文数最小下标小1，high大1，
            实际回文数下标位置是 low+1到high-1，然后从low+1到high-1这两个下标之间，一共有数字（high-1）—（low+1）+1，这个值是high-low-1
            */
            if(high-low-1 > max){
                max = high-low-1;
            }

            //回文数是奇数情况，每次循环都是遍历隔一个的两个元素
            low = i-1;
            high = i+1;
            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
                low--;
                high++;
            }
            if(high-low-1 > max){
                max = high-low-1;
            }
        }
        return max;
    }
}