package com.duomu.hj45;

import java.util.*;

/**
 * 题目描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * 输入描述:
 * 整数N，后续N个名字
 *
 * 输出描述:
 * 每个名称可能的最大漂亮程度
 *
 * 示例1
 * 输入
 * 2
 * zhangsan
 * lisi
 * 输出
 * 192
 * 101
 *
 * 思路：每一个字母都有一个漂亮度，值应在1~26之间，在输入的字符串中，按照字母的重复次数，
 * 重复次数越高，设置越大的漂亮度，以此来得到最大的漂亮度。
 * 比如lisi i出现两次，l出现一次，s出现一次，
 * i的漂亮度设置为26，l设置为25，s设置为24，因为不同字母不能有相同的漂亮度，所以只能降序设置
 * 最终lisi的可能最大漂亮度为：26*2+15*1+24*1=101
 *
 */
public class Main {
    /*注意nextLine不要和next，nextInt等混着用，next和nextInt进行输入的时候后边跟回车的话，
    会被nextLine读成空字符串，所以类似本题的内容：开始输入整型使用nextLine然后转型的方式*/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int num = Integer.parseInt(scanner.nextLine());
            List<String> list = new ArrayList<>(num);
            for (int i = 0; i < num; i++) {
                list.add(scanner.nextLine().toLowerCase());
            }
            count(list);
        }
        scanner.close();
    }
    private static void count(List<String> list){
        Map<Character,Integer> map = new HashMap<>();
        for(String name:list){
            for(int i=0;i<name.length();i++){
                if(!map.containsKey(name.charAt(i))){
                    map.put(name.charAt(i),1);
                }else{
                    map.put(name.charAt(i),map.get(name.charAt(i))+1);
                }
            }
            //获取数值
            int temp[] = new int[map.size()];
            int n = 0;
            for(Integer v:map.values()){
                temp[n++] = v;
            }
            //注意这个排序是从小到大的
            Arrays.sort(temp);
            map.clear();
            //weight相当于一个位权，从26这个值开始
            int weight = 26,result = 0;
            for(int i=temp.length-1;i>=0;i--){
                result += temp[i]*weight;
                weight--;
            }
            System.out.println(result);
        }
    }
}
