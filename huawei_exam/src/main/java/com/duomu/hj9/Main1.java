package com.duomu.hj9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            String temp = "";
            int num = Integer.parseInt(line);
            while(num>0) {
                if (!temp.contains(num % 10 + "")) {
                    System.out.print(num % 10);
                    temp += num % 10;
                }
                num /= 10;
            }
        }
    }
}
