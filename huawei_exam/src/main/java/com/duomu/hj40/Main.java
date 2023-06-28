package com.duomu.hj40;

import java.util.Scanner;
/**
 * 题目描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * 输入描述:
 * 输入一行字符串，可以有空格
 *输出描述:
 *统计其中英文字符，空格字符，数字字符，其他字符的个数
 *示例1
 *输入
 *1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 *输出
 *26
 *3
 *10
 *12
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            int letter = 0;
            int space = 0;
            int num = 0;
            int other = 0;
            for(int i=0;i<line.length();i++){
                if(Character.isLetter(line.charAt(i))){
                    //英文字符
                    letter++;
                }else if(Character.isDigit(line.charAt(i))){
                    //数字
                    num++;
                }else if(" ".equals(line.charAt(i)+"")){
                    //空格
                    space++;
                }else{
                    other++;
                }
            }
            System.out.println(letter);
            System.out.println(space);
            System.out.println(num);
            System.out.println(other);
        }
        scanner.close();
    }
}
