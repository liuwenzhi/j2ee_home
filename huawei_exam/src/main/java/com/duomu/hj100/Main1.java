package com.duomu.hj100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    private static int sum(int n){
        int temp = 2;
        int result = 2;
        while(n>1){
            temp +=3;
            result += temp;
            n--;
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=br.readLine())!=null){
            System.out.println(sum(Integer.parseInt(line)));
        }
    }
}
