package com.duomu.hj99;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=br.readLine())!=null){
            int result = 0;
            int n = Integer.parseInt(line);
            for(int i=0;i<=n;i++){
                if(isNum(i)){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
    private static boolean isNum(int n){
        int s = n*n;
        if(String.valueOf(s).endsWith(String.valueOf(n))){
            return true;
        }
        return false;
    }
}
