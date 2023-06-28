package com.duomu.hj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 * 示例1
 * 输入
 * 复制
 * hello world
 * 输出
 * 复制
 * 5
 *
 */
public class Main{
    public static void main(String[] args){
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            String[] word = br.readLine().split(" ");
            int length = word.length;
            System.out.println(word[length-1].length());
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(br!=null){
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(isr!=null){
                try {
                    isr.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
