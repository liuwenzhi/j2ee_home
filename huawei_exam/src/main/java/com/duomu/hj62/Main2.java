package com.duomu.hj62;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 无符号右移相关参考可以参考leetcode29测试说明
 */
public class Main2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(line);
            int result = 0;
            for (int i = 31; i >= 0; i--) {
                //无符号右移，int类型一共占4个字节，左移31位开始一直到移动0位，从最高位到最低位都和1做一遍与计算
                if(((num >>> i) & 1) == 1){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
