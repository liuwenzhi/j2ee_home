package com.duomu.hj7;
import java.util.Scanner;

/**
 * 思路二：对小数部分判断是否大于0.5，大于加0.5，不大于直接返回结果
 * 这种思路能比之前用的方式稍微好一点
 */
public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //输入参数
        double a = in.nextDouble();
        //取整数部分
        int b = (int)a;
        //判断
        if((a - b) >= 0.5){
            b=(int)(a + 0.5);
        }
        System.out.println(b);
    }
}
