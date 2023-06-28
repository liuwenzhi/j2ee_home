package com.duomu.hj81;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    /**定义一个辅助数组，代表26个英文字母存在标记，等于0代表该位置+a的字符不存在，大于0代表该位置+a的字符存在*/
    private static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            String shortStr = line;
            String longStr = br.readLine();
            a = new int[26];
            System.out.println(containsStr(shortStr,longStr));
        }
    }

    /**
     * 判断短字符串中的字符是否都在长字符串中出现
     * 注意：短字符串在长字符串中出现的方式可能不是连续的，或者只有部分连续
     */
    private static boolean containsStr(String shortStr,String longStr){
       for(int i=0;i<longStr.length();i++){
           char c = longStr.charAt(i);
           a[c-'a']++;
       }
       for(int i=0;i<shortStr.length();i++){
           char c = shortStr.charAt(i);
           if(a[c-'a']==0){
               return false;
           }
       }
       return true;
    }
}
