package com.duomu.hj5;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            String str = scanner.nextLine();
            //从字符串第二位开始截取，一直到最后一位，进制需要单独传入
            System.out.println(Integer.valueOf(str.substring(2),16).toString());
        }
    }
}
