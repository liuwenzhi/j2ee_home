package com.duomu.hj13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            //注意空格正则表达式形式，本题直接用空格拆分也能通过
            String s[] = line.split("\\s+");
            for (int i = s.length - 1; i >= 0; i--) {
                System.out.print(s[i] + " ");
            }
        }
    }

}
