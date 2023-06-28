package com.duomu.hj40;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用BufferedReader效率比Scanner要高很多
 */
public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int letter = 0;
            int space = 0;
            int num = 0;
            int other = 0;
            char[] c = line.toCharArray();
            for(int i=0;i<line.length();i++){
                if(c[i]>='A'&&c[i]<='Z'||c[i]>='a'&&c[i]<='z'){
                    //英文字符
                    letter++;
                }else if(c[i]>='0'&&c[i]<='9'){
                    //数字
                    num++;
                }else if(c[i]==' '){
                    //空格
                    space++;
                }else{
                    other++;
                }
            }
            System.out.println(letter);
            System.out.println(space);
            System.out.println(num);
            System.out.println(other);
        }
    }
}
