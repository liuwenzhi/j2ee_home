package com.duomu.hj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            String temp[] = line.split(" ");
            int length = temp.length;
            System.out.println(temp[length-1].length());
        }
    }
}
