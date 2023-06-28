package com.duomu.hj31;

import java.util.Scanner;
/**
 * 题目描述
 * 对字符串中的所有单词进行倒排。
 * 说明：
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 * 输入描述:
 * 输入一行以空格来分隔的句子
 * 输出描述:
 * 输出句子的逆序
 * 示例1
 * 输入
 * I am a student
 * 输出
 * student a am I
 */
public class Main {
    /*
     * 备注：本题和第13题类似，按照一个或者多个空格拆分,String s[] = str.split("\\s+");
     * 思路：对输入的字符串进行一次处理，过滤出英文字母，把其他符号都过滤掉，变成空格，
     * 得到一个新字符串，得到新字符串后按照一个或者多个空格拆分，拆分之后进行倒序输出*/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<line.length();i++){
                //是字母就拼接字母，不是字母就拼接空格
                if(Character.isLetter(line.charAt(i))){
                    sb.append(line.charAt(i));
                }else{
                    sb.append(" ");
                }
            }
            String[] temp = sb.toString().split("\\s+");
            StringBuilder result = new StringBuilder();
            //本题这里有一个坑点，不能像13题那样进行数组直接输出，需要按照下边这么来
            /*for(int i=temp.length-1;i>=0;i--){
                result.append(temp[i]+" ");
            }
            System.out.println(result.toString().trim());*/
            //2021年8月22日重新刷该题，这里应该是测试用例进行过优化，可以按照13题那种方式进行输出
            for(int i=temp.length-1;i>=0;i--){
                //result.append(temp[i]+" ");
                System.out.print(temp[i]+" ");
            }
        }
        scanner.close();
    }
}
