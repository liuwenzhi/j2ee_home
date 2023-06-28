package com.duomu.hj11;

import java.util.Scanner;

public class Main1 {
    //采用逆向遍历字符串方式实现
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextInt()+"";
        scanner.close();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=num.length()-1;i>=0;i--){
            stringBuilder.append(num.charAt(i));
        }
        System.out.println(stringBuilder.toString());
    }
}
