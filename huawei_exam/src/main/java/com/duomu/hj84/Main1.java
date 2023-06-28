package com.duomu.hj84;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            int num = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                //直接通过Character判断是否是大写字母
                if (c>='A'&&c<='Z') {
                    num++;
                }
            }
            System.out.println(num);
        }
    }
}
