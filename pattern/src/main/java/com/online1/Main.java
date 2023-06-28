package com.online1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 核心思路：滑动窗口，保留历史最大长度记录
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            int maxHistoryLength = 1;
            int right = 0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(line.charAt(0));
            while(right<line.length()-1){
                right++;
                if(!stringBuilder.toString().contains(line.charAt(right)+"")){
                    stringBuilder.append(line.charAt(right));
                    if(stringBuilder.toString().length()>maxHistoryLength){
                        maxHistoryLength++;
                    }
                }else{
                    stringBuilder.deleteCharAt(0);
                    stringBuilder.append(line.charAt(right));
                }
            }
            System.out.println(maxHistoryLength);
        }
    }
}
