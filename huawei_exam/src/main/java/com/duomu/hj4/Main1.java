package com.duomu.hj4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            StringBuffer sb=new StringBuffer(line);
            //如果s的长度不足8的倍数位，则用0补位
            if(line.length()%8!=0){
                int n=8-line.length()%8;
                for(int i=0;i<n;i++){
                    sb.append("0");
                }
            }
            //之前已经用0补位好，则直接按照8的倍数输出
            while(sb.length()>=8){
                System.out.println(sb.substring(0, 8));
                sb=sb.delete(0, 8);
            }
        }
    }
}
