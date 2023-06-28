package com.duomu.hj86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            StringBuilder sb=new StringBuilder();
            int num = Integer.parseInt(line);
            for(int i=31;i>=0;i--){
                //无符号右移，int类型一共占4个字节，左移31位开始一直到移动0位，从最高位到最低位都和1做一遍与计算
                sb.append((num>>>i)&1);
            }
            //拿到转换的二进制数字
            String binary = sb.toString();
            int max = 0;
            int cache = 0;
            for(int i=0;i<binary.length();i++){
                if(binary.charAt(i)=='1'){
                    cache++;
                }else{
                    max = Math.max(max,cache);
                    cache = 0;
                }
            }
            //补一下最后一次的比较
            max = Math.max(max,cache);
            System.out.println(max);
        }
    }
}
