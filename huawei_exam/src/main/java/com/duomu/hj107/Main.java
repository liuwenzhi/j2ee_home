package com.duomu.hj107;

import java.util.Scanner;

/**
 * 题目描述
 * 计算一个数字的立方根，不使用库函数
 *
 * 详细描述：
 *
 * •接口说明
 *
 * 原型：
 *
 * public static double getCubeRoot(double input)
 *
 * 输入:double 待求解参数
 *
 * 返回值:double  输入参数的立方根，保留一位小数
 *
 *
 * 输入描述:
 * 待求解参数 double类型
 *
 * 输出描述:
 * 输入参数的立方根 也是double类型
 *
 * 示例1
 * 输入
 *
 * 216
 * 输出
 *
 * 6.0
 */
public class Main{
    //牛顿迭代法，直接记一下结论，题解参考截图
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNextDouble()){
            double num = input.nextDouble();
            double x = 1.0;
            //1e-3代表0.001
            //for (; Math.abs(Math.pow(x,3)-num)>1e-3; x=x-((Math.pow(x,3)-num)/(3*Math.pow(x,2))));
            while(Math.abs(Math.pow(x,3)-num)>0.001){
                x=x-((Math.pow(x,3)-num)/(3*Math.pow(x,2)));
            }
            System.out.println(String.format("%.1f", x));
        }
    }
}
