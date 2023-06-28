package com.duomu.hj42;

import java.util.Scanner;

/**
 * 题目描述
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 *
 * 如22：twenty two，123：one hundred and twenty three。
 *
 *
 * 说明：
 *
 * 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
 *
 * 输出格式为twenty two；
 *
 * 非法数据请返回“error”；
 *
 * 关键字提示：and，billion，million，thousand，hundred。
 *
 *
 * 本题含有多组输入数据。
 *
 *
 * 输入描述:
 * 输入一个long型整数
 *
 * 输出描述:
 * 输出相应的英文写法
 *
 * 示例1
 * 输入
 * 复制
 * 2356
 * 输出
 * 复制
 * two thousand three hundred and fifty six
 */
public class Main {

    /**英文计数基本单位：十亿，百万，千，百万和十亿之间可以用3位数读出，千和百万之间可以用3位数读出，num1、num2和num3分别用三个基本数组表示出
     * 英文读数字的基本组成，包括0~9,10到19,20,30到90，再配合上nd，billion，million，thousand，hundred就能读出全部数字（一定范围内）
     * */
    public static String[] num1 = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    public static String[] num2 = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen","seventeen", "eighteen", "nineteen" };
    public static String[] num3 = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty","ninety" };

    public static String parse(long num){
        if(num < 0){
            return "error";
        }
        StringBuilder sb = new StringBuilder();
        long billion = num / 1000000000;    //十亿部分
        if(billion != 0){
            sb.append(trans(billion) + " billion ");
        }
        num  %= 1000000000;

        long million = num / 1000000;    //百万部分
        if(million != 0){
            sb.append(trans(million) + " million ");
        }
        num  %= 1000000;

        long thousand = num / 1000;    //千部分
        if(thousand != 0){
            sb.append(trans(thousand) + " thousand ");
        }
        num  %= 1000;

        if(num != 0){
            sb.append(trans(num));
        }
        return sb.toString().trim();   //最后去除字符串后面的空格
    }

    /**
     * 转换十亿，百万和千之间的数字，最多3位数，主要是要处理下百位，十位和个位，
     * 如果包含百位，则直接读出来，主要是十位，存在的话需要和个位一起读，如果不存在十位，则单独读个位即可
     */
    public static String trans(long num){
        StringBuilder sb = new StringBuilder();
        long h  = num / 100;  //百位处理
        if(h != 0){
            sb.append(num1[(int) h] + " hundred");
        }
        num %= 100;
        //十位处理
        long k = num / 10;
        if(k != 0){
            //如果有十位的情况，先判断是否有百位（根据h来判断）
            if(h != 0){
                //若有百位（根据h来判断），则加上“and”
                sb.append(" and ");
            }
            if(k == 1){   //如果十位为1，那么十位与个位一起翻译，如：113
                sb.append(num2[(int)(num % 10)]);
            }else{  //否则，十位和个位分别单独翻译，如：123，nums3要取k-2，从twenty到ninety，对应下标为0到7，
                sb.append(num3[(int) (k - 2)] + " ");
                if(num % 10 != 0){
                    sb.append(num1[(int) (num % 10)]);
                }
            }
        }else if (num % 10 != 0) {
            //如果没有十位的部分，并且存在个位，则直接翻译个位部分，比如：102
            if(h != 0){
                //还需要先判断下是否有百位（根据h来判断），有则加上“and”
                sb.append(" and ");
            }
            //num%10直接就是个位
            sb.append(num1[(int) (num % 10 )]);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //备注：本题说长度不超过9位，int类型最大值是2147483647，长度是9位，这里必须要使用Long类型保证不会出现数组越界或者Format异常
            long num = in.nextLong();
            System.out.println(parse(num));
        }
        in.close();
    }
}
