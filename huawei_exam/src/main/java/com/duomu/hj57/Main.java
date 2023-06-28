package com.duomu.hj57;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 参考leetcode415题整理本题题解
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            String num1 = line;
            String num2 = br.readLine();
            //取两个字符串的长度，注意：字符串表示的数字进行计算，需要从字符串的高位（实际是数字的低位）开始
            int i = num1.length()-1,j=num2.length()-1;
            //add是进位
            int add = 0;
            StringBuilder result = new StringBuilder();
            //i位，j位还有进位三个数都要考虑，并做累加
            while(i>=0||j>=0||add > 0){
                int val1 = i>=0?num1.charAt(i) - '0':0;
                int val2 = j>=0?num2.charAt(j) - '0':0;
                int temp = val1+val2+add;
                //每次计算一次进位
                add = temp/10;
                //每次将计算结果拼接到result后边，最后需要把结果翻转一下
                result.append(temp%10);
                i--;j--;
            }
            System.out.println(result.reverse().toString());
        }
    }
}
