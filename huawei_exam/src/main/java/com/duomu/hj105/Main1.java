package com.duomu.hj105;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        //负数个数
        int num1 = 0;
        //正整数个数
        int num2 = 0;
        //正整数累加和
        double total = 0;
        while(scanner.hasNext()){
            int k = scanner.nextInt();
            if(k<0){
                num1++;
            }
            if(k>0){
                num2++;
                total+=k;
            }
        }
        System.out.println(num1);
        System.out.println(decimalFormat.format(total/num2));
        scanner.close();
    }
}
