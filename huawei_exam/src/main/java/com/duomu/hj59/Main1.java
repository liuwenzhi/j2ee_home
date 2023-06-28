package com.duomu.hj59;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args)throws IOException {
        Map<Character,Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            for(int i=0;i<line.length();i++){
                if(map.containsKey(line.charAt(i))){
                    map.put(line.charAt(i),map.get(line.charAt(i))+1);
                }else{
                    map.put(line.charAt(i),1);
                }
            }
            boolean flag = false;
            for(int i=0;i<line.length();i++){
                if(map.get(line.charAt(i))==1){
                    flag = true;
                    System.out.println(line.charAt(i));
                    //输出完第一个之后直接退出
                    break;
                }
            }
            if(!flag){
                System.out.println(-1);
            }
            map.clear();
        }
    }
}
