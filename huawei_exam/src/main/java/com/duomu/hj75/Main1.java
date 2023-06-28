package com.duomu.hj75;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    /*思路：本题和65题思路类似*/
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            String line1 = line;
            String line2 = br.readLine();
            if(line1.length()>=line2.length()){
                System.out.println(getCommonLength(line1,line2));
            }else{
                System.out.println(getCommonLength(line2,line1));
            }
        }
    }

    /**
     * @param line1 长的串
     * @param line2 短的串
     */
    private static int getCommonLength(String line1,String line2){
        int max = 0;
        //从头往后遍历短的，提取子串
        for(int i=0;i<line2.length();i++){
            for(int j=line2.length();j>i;j--){
                //加一步不区分大小写
                if(line1.toLowerCase().contains(line2.substring(i,j).toLowerCase())){
                    max = Math.max(max,line2.substring(i,j).length());
                }
            }
        }
        return max;
    }
}
