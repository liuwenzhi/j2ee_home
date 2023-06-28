package com.duomu.hj50;

import java.io.IOException;
import java.io.InputStream;
/**
 * 题目描述
 * 请实现如下接口
 *     /* 功能：四则运算
 *      * 输入：strExpression：字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"
 *          * 返回：算术表达式的计算结果
 *public static int calculate(String strExpression)
 *{
 *return 0;
 *}
 *约束：
 *pucExpression字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。
 *pucExpression算术表达式的有效性由调用者保证;
 *输入描述:
 *输入一个算术表达式
 *输出描述:
 *得到计算结果
 *示例1
 *输入
 *3+2*{1+2*[-4/(8-6)+7]}
 *输出
 *25
 */
/**
 * 50题和54题解法一致
 */
public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        System.out.println(new Expression().compute(in));
    }

    public static class Expression {
        public char lastsign1 = 0, lastsign2 = 0;
        public int temp1 = 0, temp2 = 0;
        private static final char tempchar = 0;

        public int compute(InputStream in) throws IOException {
            int result = 0;
            char c;
            //一个字符一个字符的读取，一直读到换行符的位置
            a: while((c = (char)in.read()) != '\n') {
                switch (c) {
                    case ')':
                    case ']':
                    case '}': break a;//遇到右括号就退出while循环，包括小括号，中括号和大括号
                    case '(':
                    case '[':
                    case '{': temp2 = new Expression().compute(in); break;//遇到左边括号，就新建一个Expression去计算括号里边的值，包括小括号，中括号和大括号
                    case '+':
                    case '-':
                        compute1(tempchar);
                        result = compute2(c, result);
                        break;
                    case '*':
                    case '/':
                        compute1(c);
                        break;
                    default: temp2 = temp2 * 10 + c - '0'; break;//c-'0'相当于把c数值化
                }
            }
            //在while循环之后补上最后一次计算，先补乘除运算，之后再补一次加减运算
            compute1(tempchar);
            result = compute2(tempchar, result);
            return result;
        }

        /**
         * 计算乘除法，计算的同时还有赋值操作，每次传入参数c，先计算上一次的内容，然后再把c赋值给元素安抚
         */
        private void compute1(char c) {
            switch (lastsign2) {
                case 0: temp1 = temp2; break;
                case '*': temp1 *= temp2; break;
                case '/': temp1 /= temp2; break;
                default: break;
            }
            temp2 = 0;
            lastsign2 = c;
        }

        /**
         * 计算加减法，计算的同时还有赋值操作，每次传入参数c，先计算上一次的内容，然后再把c赋值给元素安抚
         */
        private int compute2(char c, int result) {
            switch (lastsign1) {
                case 0: result = temp1; break;
                case '-': result -= temp1; break;
                case '+': result += temp1; break;
                default: break;
            }
            temp1 = 0;
            lastsign1 = c;
            return result;
        }
    }
}
