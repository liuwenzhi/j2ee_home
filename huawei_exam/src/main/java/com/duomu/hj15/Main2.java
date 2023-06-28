package com.duomu.hj15;

import java.util.Scanner;

/**
 * 这个思路比Main1效率高一些，进行替换会比较耗时
 */
public class Main2 {
    public static void main(String[] arg){
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int i=31;i>=0;i--){
            //无符号右移，int类型一共占4个字节，左移31位开始一直到移动0位，从最高位到最低位都和1做一遍与计算
            sb.append((num>>>i)&1);
        }
        //拿到转换的二进制数字
        String line=sb.toString();
        int result = 0;
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='1'){
                result++;
            }
        }
        System.out.println(result);

    }
}
