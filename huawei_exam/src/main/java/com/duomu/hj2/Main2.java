package com.duomu.hj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 个人思路：字母转小写直接比较
 * 耗时：17ms
 */
public class Main2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            //从客户端接收第二行字符next接收一个字符串，直接以字符的方式获取该字符串的第一个字符，实际相当于模拟了一个字符输入
            char character = br.readLine().charAt(0);
            int result = 0;
            for(int i=0;i<line.length();i++){
                char c = line.charAt(i);
                //直接转小写字母比较
                if((String.valueOf(c).toLowerCase()).equals((String.valueOf(character).toLowerCase()))){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
