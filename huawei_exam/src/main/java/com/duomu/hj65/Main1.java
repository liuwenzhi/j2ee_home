package com.duomu.hj65;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            String line1 = line;
            String line2 = br.readLine();
            //字符串的长短根据输入单独确认下
            if(line1.length()>=line2.length()){
                System.out.println(getCommonStr(line1,line2));
            }else{
                System.out.println(getCommonStr(line2,line1));
            }
        }
    }

    /**
     * @param line1 长的串
     * @param line2 短的串
     */
    private static String getCommonStr(String line1,String line2){
        String common = "";
        //从头往后遍历短的，提取子串，外层for循环找短字符串的左边界，内层for循环找短字符串的右边界
        for(int i=0;i<line2.length();i++){
            for(int j=line2.length();j>i;j--){
                //如果长的包含短的，子串，则满足公共字符串条件，再进行长度判断
                if(line1.contains(line2.substring(i,j))){
                    //只在common比公共子串长度短的时候进行替换
                    if(common.length()<line2.substring(i,j).length()){
                        common = line2.substring(i,j);
                    }
                    //内层for循环确定右边界，从最大的开始找，如果出现了包含字符串的情况，已经是当前开始位置最大的子串了，直接跳出当前内层for循环不往后走了
                    break;
                }
            }
        }
        return common;
    }
}
