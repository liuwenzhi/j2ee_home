package com.duomu.hj59;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 找出字符串中第一个只出现一次的字符
 * 输入描述:
 * 输入几个非空字符串
 *
 * 输出描述:
 * 输出第一个只出现一次的字符，如果不存在输出-1
 *
 * 示例1
 * 输入
 * asdfasdfo
 * aabb
 * 输出
 * o
 * -1
 */
public class Main {
    /**
     * 思路：将字符串中每一个字符和对应的出现的次数以key value方式存放到map集合中，
     * 然后从头到尾重新遍历字符串，找每一个字符对应的出现次数，第一个value为1则返回该字符，
     * 如果遍历到结尾还没有出现次数为1的字符，则返回-1，本题按这种思路和使用HashMap和LinkedHashMap没有多大关系
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            for(int i=0;i<line.length();i++){
                if(map.containsKey(line.charAt(i))){
                    map.put(line.charAt(i),map.get(line.charAt(i))+1);
                }else{
                    map.put(line.charAt(i),1);
                }
            }
            boolean flag = false;
            for(int i=0;i<line.length();i++){
                if(map.get(line.charAt(i))==1){
                    flag = true;
                    System.out.println(line.charAt(i));
                    //输出完第一个之后直接退出
                    break;
                }
            }
            if(!flag){
                System.out.println(-1);
            }
            map.clear();
        }
        scanner.close();
    }
}
