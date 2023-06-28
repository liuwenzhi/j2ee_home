package com.duomu.hj11;

import java.util.Scanner;

/**
 * 个人思路：通过StringBuilder的reverse方法直接反转字符串
 */
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(scanner.nextInt()+"");
        scanner.close();
        System.out.println(stringBuilder.reverse());
    }
}
