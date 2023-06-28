package com.duomu.hj89;
import java.util.Scanner;
import java.util.LinkedList;
/**
 * 题目描述
 * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
 *
 *                    3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 *
 * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
 *
 * 详细说明：
 *
 * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，友情提醒，整数除法要当心；
 * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
 * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 4.输出的算式格式为4张牌通过 + - * / 四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
        * 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24
        *6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
        *
        *输入描述:
        *输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
        *
        *输出描述:
        *如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
        *示例1
        *输入
        *复制
        *A A A A
        *输出
        *复制
        *NONE
 */
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //用于初步读取String储存
        LinkedList<String> list1 = new LinkedList<>();
        //用于将String转化成int储存
        LinkedList<Integer> list = new LinkedList<>();
        //用于还原：（1->A; 13->K）
        LinkedList<String> list2 = new LinkedList<>();

        list2.add("0");
        list2.add("A");
        for (int i = 2; i <= 10; i++){
            list2.add(Integer.toString(i));
        }
        list2.add("J");
        list2.add("Q");
        list2.add("K");
        //读取String：
        while (sc.hasNext()){
            list1.add(sc.next());
        }
        int flag = 0;
        //转换成Integer：//遇到JOKER 直接输出ERROR
        for (int i = 0; i < 4 ; i++){
            String cur = list1.get(i);
            if (cur.equals("JOKER") || cur.equals("joker")){
                System.out.println("ERROR");
                flag = -1;
                break;
            }else if (cur.equals("A")){
                list.add(1);
            }else if (cur.equals("K")){
                list.add(13);
            }else if (cur.equals("Q")){
                list.add(12);
            }else if (cur.equals("J")){
                list.add(11);
            }else{
                list.add(Integer.valueOf(cur));
            }
        }
        //暴力遍历四个数的排列组合：
        if (flag == 0){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if (j == i) continue;
                    if(flag == 1) break;
                    for (int k = 0; k < 4; k++){
                        if (k == i || k == j) continue;
                        if(flag == 1) break;
                        for (int p = 0; p < 4; p++){
                            if (p == i || p == j || p == k) continue;
                            if(flag == 1) break;
                            //将四个数给如helper function做判断：
                            String out = helper(list.get(i), list.get(j), list.get(k),list.get(p));
                            //输出非NONE，生成答案：
                            if (!out.equals("NONE")){
                                String res = "";
                                res += list2.get(list.get(i));
                                res += out.substring(0,1);
                                res += list2.get(list.get(j));
                                res += out.substring(1,2);
                                res += list2.get(list.get(k));
                                res += out.substring(2,3);
                                res += list2.get(list.get(p));
                                System.out.println(res);
                                flag = 1;
                            }
                        }
                    }
                }
            }
            //helepr function输出为NONE输出NONE：
            if (flag == 0) System.out.println("NONE");
        }
    }
    //类似于2-sum --> 3-sum -->4-sum思路：
    static public String helper(int a, int b){
        if (a * b == 24) return "*";
        else if (a + b == 24) return "+";
        else if (b != 0 && a % b == 0 && a / b == 24) return "/";
        else if (a - b == 24) return "-";
        else return "NONE";
    }
    //重载
    static public String helper(int a, int b, int c){
        if (!helper(a * b, c).equals("NONE")) return "*" + helper(a * b, c);
        else if (!helper(a + b, c).equals("NONE")) return "+" + helper(a + b, c);
        else if (!helper(a - b, c).equals("NONE")) return "-" + helper(a - b, c);
        else if (b != 0 && a % b == 0 && !helper(a / b, c).equals("NONE")) return "/" + helper(a * b, c);
        else return "NONE";
    }
    //重载：输出的是三个有序运算符号
    static public String helper(int a, int b, int c, int d){
        if (!helper(a * b, c, d).equals("NONE")) return "*" + helper(a * b, c, d);
        else if (!helper(a + b, c, d).equals("NONE")) return "+" + helper(a + b, c, d);
        else if (!helper(a - b, c, d).equals("NONE")) return "-" + helper(a - b, c, d);
        else if (b != 0 && a % b == 0 && !helper(a / b, c, d).equals("NONE")) return "/" + helper(a * b, c, d);
        else return "NONE";
    }
}
