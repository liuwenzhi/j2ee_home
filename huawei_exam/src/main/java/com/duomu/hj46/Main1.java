package com.duomu.hj46;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int num = Integer.parseInt(br.readLine());
            System.out.println(line.substring(0,num));
        }
    }
}
