package com.duomu.hj55;

import java.util.Scanner;

/**
 * 题目描述
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
 *
 * 输入描述:
 * 一个正整数N。(N不大于30000)
 *
 * 输出描述:
 * 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 *
 * 示例1
 * 输入
 * 20
 * 输出
 * 3
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            System.out.println(get7num(num));
        }
    }

    private static int get7num(int num){
        int result = 0;
        //注意从1到num，包含1和num，不能包括有0
        for(int i=1;i<=num;i++){
            if(i%7==0){
                result++;
            }else if(String.valueOf(i).contains("7")){
                result++;
            }
        }
        return result;
    }
}
