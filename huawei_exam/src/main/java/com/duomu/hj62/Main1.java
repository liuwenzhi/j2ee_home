package com.duomu.hj62;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(line);
            for (int i = 31; i >= 0; i--) {
                //无符号右移，int类型一共占4个字节，左移31位开始一直到移动0位，从最高位到最低位都和1做一遍与计算
                sb.append((num >>> i) & 1);
            }
            //拿到转换的二进制数字
            String line1 = sb.toString();
            //System.out.println(line);
            //转成二进制数字之后统计1的个数，通过替换1为空字符串，然后计算字符串和原始字符串长度差
            System.out.println(line1.length() - line1.replaceAll("1", "").length());
        }
    }
}
