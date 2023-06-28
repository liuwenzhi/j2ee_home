package com.duomu.hj55;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int num = Integer.parseInt(line);
            System.out.println(get7num(num));
        }
    }

    private static int get7num(int num){
        int result = 0;
        //注意从1到num，包含1和num，不能包括有0
        for(int i=1;i<=num;i++){
            if(i%7==0){
                result++;
            }else if(String.valueOf(i).contains("7")){
                result++;
            }
        }
        return result;
    }
}
