package com.duomu.hj75;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 一个优化的方法，通过遍历数组来提高效率。可以参考下
 */
public class Main2 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        String str2 = "";

        while((str1 = bf.readLine())!= null && (str2 = bf.readLine())!= null){
            int max = 0;
            char[] cha1 = str1.toCharArray();
            char[] cha2 = str2.toCharArray();
            for(int i = 0; i < str1.length(); i++){
                for(int j = 0; j < str2.length(); j++){
                    int t1 = i;
                    int t2 = j;
                    int count = 0;
                    while(cha1[t1] == cha2[t2]){
                        t1++;
                        t2++;
                        count++;
                        max = Math.max(count,max);
                        if(t1 == cha1.length || t2 == cha2.length) break;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
