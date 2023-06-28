package com.duomu.hj74;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 对Main1的优化，直接遍历字符，也是通过奇偶数的方式解析参数
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            char[] chars=line.toCharArray();
            StringBuffer ana=new StringBuffer();
            int flag=0;
            int count=1;
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='\"'){
                    flag++;
                    continue;
                }
                if(chars[i]!=' '){
                    ana.append(chars[i]);
                }
                if(chars[i]==' '&&flag%2!=0){
                    ana.append(chars[i]);
                }
                if(chars[i]==' '&&flag%2==0){
                    ana.append("\n");
                    count++;
                }
            }
            System.out.println(count+"\n"+ana.toString());
        }
    }

}
