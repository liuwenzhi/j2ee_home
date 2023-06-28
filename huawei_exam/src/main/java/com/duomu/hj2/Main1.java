package com.duomu.hj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 直接替换思路耗时16ms
 */
public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            //从客户端接收第二行字符next接收一个字符串，直接以字符的方式获取该字符串的第一个字符，实际相当于模拟了一个字符输入
            char character = br.readLine().charAt(0);
            //获取到字符对应的大写或者小写形式
            char character1 = Character.isUpperCase(character) ? Character.toLowerCase(character) : Character.toUpperCase(character);
            //计算原始字符串长度
            int length = line.length();
            //将原始字符串中输入字符和对应的大写或者小写字符替换成空字符，再计算一次长度
            int newLength = line.replace(String.valueOf(character), "").replace(String.valueOf(character1), "").length();
            System.out.println(length - newLength);
        }
    }
}
