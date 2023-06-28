package com.duomu.hj63;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            int n = 0;
            String result = "";
            int num = Integer.parseInt(br.readLine());
            //for语句中的条件一定要有+1，不然会漏数据，可以这么来理解：line.length()-(line.length()-num+1)+1=num个元素
            for(int i=0;i<line.length()-num+1;i++){
                int d = getSub(line.substring(i,i+num));
                if(d>n){
                    result = line.substring(i,i+num);
                    n = d;
                }
            }
            System.out.println(result);
        }
    }
    /**
     * 获取一个字符串中，G和C两个字母的数量（用数量代替比例，省去做除法）
     */
    private static int getSub(String str){
        int num = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='G'||str.charAt(i)=='C'){
                num++;
            }
        }
        return num;
    }
}
