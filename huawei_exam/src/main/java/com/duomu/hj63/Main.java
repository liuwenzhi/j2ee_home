package com.duomu.hj63;

import java.util.Scanner;
/**
 * 题目描述
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
 *
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 *
 * 输入描述:
 * 输入一个string型基因序列，和int型子串的长度
 * 输出描述:
 * 找出GC比例最高的子串,如果有多个输出第一个的子串
 * 示例1
 * 输入
 * AACTGTGCACGACCTGA
 * 5
 * 输出
 * GCACG
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = 0;
            String result = "";
            String line = scanner.nextLine();
            int num = Integer.parseInt(scanner.nextLine());
            //for语句中的条件一定要有+1，不然会漏数据，可以这么来理解：line.length()-(line.length()-num+1)+1=num个元素
            for(int i=0;i<line.length()-num+1;i++){
                int d = getSub(line.substring(i,i+num));
                if(d>n){
                    result = line.substring(i,i+num);
                    n = d;
                }
            }
            System.out.println(result);
        }
    }
    /**
     * 获取一个字符串中，G和C两个字母的数量（用数量代替比例，省去做除法）
     */
    private static int getSub(String str){
        int num = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='G'||str.charAt(i)=='C'){
                num++;
            }
        }
        return num;
    }
}
