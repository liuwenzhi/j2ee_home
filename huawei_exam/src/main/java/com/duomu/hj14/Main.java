package com.duomu.hj14;

import java.util.*;

/**
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入
 * 复制
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class Main {
    /**核心思路Collections.sort实现字典排序，注意：本题不能使用treeset，题目要求不能进行去重*/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            //String[] s = new String[num];
            List<String> list = new ArrayList<>(num);
            for(int i=0;i<num;i++){
                list.add(scanner.next());
            }
            //用collections.sort方式实现字典排序
            Collections.sort(list);
            for(String s1:list){
                System.out.println(s1);
            }
        }
        scanner.close();
    }
}
