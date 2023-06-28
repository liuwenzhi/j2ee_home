package com.duomu.hj26;

import java.util.*;

/**
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。(关键点：同一个字母大小写同时存在，排序不换位)
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 *
 *
 * 输入描述:
 * 输入字符串
 * 输出描述:
 * 输出字符串
 * 示例1
 * 输入
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println(sort(line));
        }
    }

    private static String sort(String line){
        //统计字母个数
        int letterCount = 0;
        for(int i=0;i<line.length();i++){
            //直接使用Character的API判断是否是字母，可以用大于等于a(A)，小于等于z(Z)这种
            if(Character.isLetter(line.charAt(i))){
                letterCount++;
            }
        }
        //提取字母，进行排序
        List<Character> list = new ArrayList<>(letterCount);
        for(int i=0;i<line.length();i++){
            if(Character.isLetter(line.charAt(i))){
                list.add(line.charAt(i));
            }
        }
        //字母排序，比较小写字母，保证同一个字母大小写同时存在不换位
        list.sort(new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });

        //最终返回结果，重新拼接字符串
        StringBuilder sb = new StringBuilder();
        //拼接结果，数字直接放在原位置，字母按照排序好的顺序存放
        for(int i=0,j=0;i<line.length();i++){
            if(Character.isLetter(line.charAt(i))){
                sb.append(list.get(j++));
            }else{
                sb.append(line.charAt(i));
            }
        }
        return sb.toString();
    }

}
