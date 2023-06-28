package com.duomu.hj23;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入
 * abcdd
 * 输出
 * dd
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //使用HashMap初始化，能把运行时间提升10ms，没有必要像Main1那样在while循环中每次初始化map，Main1可以作为一个参考
        HashMap<Character,Integer> map = new HashMap<>();
        while(scanner.hasNext()){
            //记录出现最小次数数值
            int min = Integer.MAX_VALUE;
            String line = scanner.nextLine();
            //遍历字符串，提取字母出现次数
            for(int i=0;i<line.length();i++){
                if(!map.containsKey(line.charAt(i))){
                    map.put(line.charAt(i),1);
                }else{
                    map.put(line.charAt(i),map.get(line.charAt(i))+1);
                }
            }
            //获取出现次数最小值
            for(Integer v:map.values()){
                min = v<min?v:min;
            }
            //再次遍历字符串，输出出现次数不是最小值的那些字母
            for(int i=0;i<line.length();i++){
                if(map.get(line.charAt(i)) > min){
                    System.out.print(line.charAt(i));
                }
            }
            System.out.println();
            map.clear();
        }
    }
}
