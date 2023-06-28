package com.duomu.hj56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 注意区别本题和hj6，hj6求的是质数因子，本题是真因子
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int n = Integer.parseInt(line);
            System.out.println(count(n));
        }
    }

    private static int count(int n){
        //result记录累计数量
        int result = 0;
        int temp = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                if(i%j==0){
                    temp+=j;
                }
            }
            if(temp==i){
                result ++;
                //测试看下这个数字是多少，6,28,496
                //System.out.println(temp);
            }
            //每次temp重新计数，作为一个临时的累加变量
            temp = 0;
        }
        return result;
    }
}
