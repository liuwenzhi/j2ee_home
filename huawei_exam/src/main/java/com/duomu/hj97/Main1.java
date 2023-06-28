package com.duomu.hj97;

import java.util.Scanner;

/**
 * 采用格式化站位的输出设计不错
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int count1 = 0;
            int count2 = 0;
            int sum = 0;
            int in = 0;
            for(int i = 0; i < n; i++){
                in  = sc.nextInt();
                if(in > 0){
                    count1++;
                    sum += in;
                }else if(in < 0){
                    count2++;
                }
            }
            System.out.printf("%d %.1f\n",count2, (sum * 1.0 / count1));
        }
    }
}
