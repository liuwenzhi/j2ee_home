package com.duomu.hj5;

import java.util.Scanner;

/**
 * 算法实现，单独计算每一位的权值（每一位*16，然后再转十进制）
 */
public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String num = str.substring(2,str.length());
            int result = 0;
            int power = 1;
            for(int i = num.length() - 1; i >= 0; i--){
                char c = num.charAt(i);
                if(c >= '0' && c <= '9'){
                    result += (c - '0') * power;
                }else if (c >= 'A' && c <= 'F'){
                    result += (c - 'A' + 10) * power;
                }
                power *= 16;
            }
            System.out.println(result);
        }
        sc.close();
    }
}
