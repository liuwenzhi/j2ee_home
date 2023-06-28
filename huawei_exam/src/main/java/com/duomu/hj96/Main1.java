package com.duomu.hj96;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 和Main一个思路，优化下输入
 * 2021年9月16日三轮刷题，发现测试用例居然把Main方法的思路给覆盖了，**能够被屏蔽，那我就玩一个竖线替换。
 */
public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            System.out.println(MarkNum(str));
        }
    }

    private static String MarkNum(String pInStr){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<pInStr.length();i++){
            if(pInStr.charAt(i)>='0'&&pInStr.charAt(i)<='9'){
                sb.append("|").append(pInStr.charAt(i)).append("|");
            }else{
                sb.append(pInStr.charAt(i));
            }
        }
        return sb.toString().replace("||","").replace("1","*");
    }
}
