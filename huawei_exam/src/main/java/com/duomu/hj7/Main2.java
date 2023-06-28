package com.duomu.hj7;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //输入参数
        float a = in.nextFloat();
        //取整数部分
        int b = (int)a;
        //判断
        if((a - b) >= 0.5){
            b=(int)(a + 0.5);
        }
        System.out.println(b);
    }
}
