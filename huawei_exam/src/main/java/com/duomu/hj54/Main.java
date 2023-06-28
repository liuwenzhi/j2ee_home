package com.duomu.hj54;

import java.io.*;

/**
 * 题目描述
 * 给定一个字符串描述的算术表达式，计算出结果值。
 *
 * 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
 *
 * 输入描述:
 * 输入算术表达式
 *
 * 输出描述:
 * 计算出结果值
 *
 * 示例1
 * 输入
 * 复制
 * 400+5
 * 输出
 * 复制
 * 405
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
                    case ')':break a;//遇到有括号就退出while循环
                    case '(':temp2 = new Expression().compute(in); break;//遇到左边括号，就新建一个Expression去计算括号里边的值
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
         * 计算乘除法，计算的同时还有赋值操作，每次传入参数c，先计算上一次的内容，然后再把c赋值给元素符号
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
         * 计算加减法，计算的同时还有赋值操作，每次传入参数c，先计算上一次的内容，然后再把c赋值给元素符号
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
