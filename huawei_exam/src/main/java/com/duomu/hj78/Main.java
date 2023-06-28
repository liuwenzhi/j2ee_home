package com.duomu.hj78;

import java.util.Scanner;
/**
 * 题目描述
 * 请设计一个算法完成两个超长正整数的加法。
 *
 *
 * 接口说明
 *
 *
 * /*
 * 请设计一个算法完成两个超长正整数的加法。
 * 输入参数：
 * String addend：加数
 * String augend：被加数
 * 返回值：加法结果
         *public String AddLongInteger(String addend,String augend)
        *{
        *return null;
        *}
        *本题有多组输入数据，请使用while(cin>>)等方式读取
        *输入描述:
        *输入两个字符串数字
        *输出描述:
        *输出相加后的结果，string型
        *示例1
        *输入
        *99999999999999999999999999999999999999999999999999
        *输出
        *100000000000000000000000000000000000000000000000000
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String addend = scanner.next();
            String augend = scanner.next();
            System.out.println(addLongInteger(addend,augend));
        }
        scanner.close();
    }
    private static String addLongInteger(String addend,String augend){
        StringBuilder stringBuilder = new StringBuilder();
        //i代表被加数长度
        int i = augend.length()-1;
        //j代表加数长度
        int j = addend.length()-1;
        //进位值
        int carry = 0;
        while(i>=0||j>=0||carry>0){
            //sum作为缓存变量记录加数、被加数和进位相加后的值，如果涉及到进位则最后sum值%10
            int sum = carry;
            if(i>=0){
                //进行被加数每一位计算，每一次计算完成后i向前移动一位
                sum += Integer.parseInt(augend.charAt(i)+"");
                i--;
            }
            if(j>=0){
                //进行加数每一位计算，每一次计算完成后j向前移动一位
                sum += Integer.parseInt(addend.charAt(j)+"");
                j--;
            }
            //如果涉及到进位，则sum%10，其实不涉及进位，sum%10也没问题
            if(sum >= 10){
                sum = sum%10;
                carry = 1;
            }else{
                carry = 0;
            }
            stringBuilder.append(sum);
        }
        return stringBuilder.reverse().toString();
    }
}
