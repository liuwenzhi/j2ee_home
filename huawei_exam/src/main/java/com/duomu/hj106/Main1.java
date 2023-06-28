package com.duomu.hj106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    /**本题和12题思路一致*/
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=br.readLine())!=null) {
            for(int i=line.length()-1;i>=0;i--){
                System.out.print(line.charAt(i));
            }
            System.out.println();
        }
    }
}
