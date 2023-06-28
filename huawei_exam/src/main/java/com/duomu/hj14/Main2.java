package com.duomu.hj14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 用Arrays.sort实现排序，效率没有Colletcions.sort高
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++){
                String str = sc.next();
                arr[i] = str;
            }
            Arrays.sort(arr);
            for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]);
            }
        }
        sc.close();
    }
}
