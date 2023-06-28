package com.duomu.hj24;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            int temp = 0;
            int[] Inc = new int[n];
            int[] Dec = new int[n];
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = s.nextInt();
            }
            Inc[0] = 1;
            for(int i = 1; i < n; i++){
                Inc[i] = 1;
                for(int j = 0; j < i; j++){
                    if(arr[j] < arr[i] && Inc[j] + 1 > Inc[i]){
                        Inc[i] = Inc[j] + 1;
                    }
                }
            }
            Dec[n - 1] = 1;
            for(int i = n -2; i >= 0; i--){
                Dec[i] = 1;
                for(int j = n - 1; j > i; j--){
                    if(arr[j] < arr[i] && Dec[j] + 1 > Dec[i]){
                        Dec[i] = Dec[j] + 1;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                if(Inc[i] + Dec[i] - 1 > temp)
                    temp = Inc[i] + Dec[i] - 1;
            }
            System.out.println(n - temp);
        }
    }
}
