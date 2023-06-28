package com.duomu.hj72;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        int num;
        while((line=br.readLine())!=null){
            for (int i = 0; i <= 20; i++) {
                for (int j = 0; j <= 33; j++) {
                    int k = 100 - i - j;
                    //鸡雏买0只或者大于等于3的倍数只
                    if ((k % 3 == 0) && (i * 5 + j * 3 + k / 3 == 100)) {
                        System.out.println(i+" "+j+" "+k);
                    }
                }
            }
        }
    }
}
