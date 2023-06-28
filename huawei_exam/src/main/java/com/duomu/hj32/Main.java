package com.duomu.hj32;

import java.util.Scanner;
/**
 * 题目描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
 * 但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
 * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，
 * 他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 输入描述:
 * 输入一个字符串
 *
 * 输出描述:
 * 返回有效密码串的最大长度
 *
 * 示例1
 * 输入
 * ABBA
 * 输出
 * 4
 */
public class Main {
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
