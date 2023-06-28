package com.duomu.hj92;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            System.out.println(getDigitInfo(line));
        }
    }

    private static String getDigitInfo(String line){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<line.length();i++){
            //是数字就拼接数字字符，不是数字就拼接a
            if(Character.isDigit(line.charAt(i))){
                stringBuilder.append(line.charAt(i));
            }else{
                stringBuilder.append('a');
            }
        }
        //按照1个到多个a来拆分
        String[] cache = stringBuilder.toString().split("a+");
        //最大数字串长度
        int max = 0;
        for(int i=0;i<cache.length;i++){
            //找到max最大值
            max = max<cache[i].length()?cache[i].length():max;
        }
        String temp = "";
        for (String s : cache) {
            if(s.length()==max){
                temp+=s;
            }
        }
        return temp+","+max;
    }
}
