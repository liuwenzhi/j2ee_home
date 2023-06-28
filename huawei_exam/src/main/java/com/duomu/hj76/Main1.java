package com.duomu.hj76;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            int num = Integer.parseInt(line);
            //根据已有算法或者公式定位出累加队列开始位置
            int start = num*num-(num-1);
            String result = "";
            for(int i=0;i<num;i++){
                if(i!=num-1){
                    result+=start+"+";
                }else{
                    result+=start;
                }
                start+=2;
            }
            System.out.println(result);
        }
    }
}
