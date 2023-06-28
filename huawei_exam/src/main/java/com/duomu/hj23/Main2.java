package com.duomu.hj23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 用缓存数组代替Map，注意题干中的信息：输入只有小写字母
 */
public class Main2 {
    public static void main(String[] args)throws IOException {
        //字母出现次数缓存数组，0到25标记a到z
        int[] cache;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            //每次一个新的录入都重新初始化一下cache
            cache = new int[26];
            //记录出现最小次数数值
            int min = Integer.MAX_VALUE;
            for(int i=0;i<line.length();i++){
                cache[line.charAt(i)-'a']++;
            }
            for(int i=0;i<cache.length;i++){
                //注意这里的条件一定要有cache[i]>0，出现的字母进行统计比较
                if(cache[i]>0&&min>cache[i]){
                    min = cache[i];
                }
            }
            //将出现次数不是最小值的字符全都输出
            for(int i=0;i<line.length();i++){
                if(cache[line.charAt(i)-'a']>min){
                    System.out.print(line.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
