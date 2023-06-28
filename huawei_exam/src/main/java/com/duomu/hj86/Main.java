package com.duomu.hj86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 题目描述
 * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 *
 * 输入: 一个byte型的数字
 *
 * 输出: 无
 *
 * 返回: 对应的二进制数字中1的最大连续数
 * 输入描述:
 * 输入一个byte数字
 *
 * 输出描述:
 * 输出转成二进制之后连续1的个数
 *
 * 示例1
 * 输入
 * 3
 * 输出
 * 2
 */
public class Main {
    /**
     * 注意：本题有坑，不能用在线上不能用byte类型，需要用整型
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            int num = Integer.parseInt(line);
            String binary = Integer.toBinaryString(num);
            int max = 0;
            int cache = 0;
            for(int i=0;i<binary.length();i++){
                if(binary.charAt(i)=='1'){
                    cache++;
                }else{
                    max = Math.max(max,cache);
                    cache = 0;
                }
            }
            //补一下最后一次的比较
            max = Math.max(max,cache);
            System.out.println(max);
        }
    }
}
