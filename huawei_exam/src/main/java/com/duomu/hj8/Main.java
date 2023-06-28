package com.duomu.hj8;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 * 输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 0 3
 * 1 2
 * 3 4
 */
public class Main {
    public static void main(String[] args){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //记录总量
            int num = scanner.nextInt();
            for(int i=0;i<num;i++){
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else{
                    map.put(key,value);
                }
            }
        }
        //Map.Entry<String, Integer> entry : tempMap.entrySet()
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}