package com.duomu.hj108;

import java.util.Scanner;

/**
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述:
 * 输入两个正整数A和B。
 *
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 * 示例1
 * 输入
 * 复制
 * 5 7
 * 输出
 * 复制
 * 35
 */
public class Main {
    /**
     * 本题大学接触过，思路再看下，和第六题类似，都是本科接触过的算法
     */
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=a*b;
        if(a<b){
            //r是中间变量，如果a比b小，则ab换位，r作为换位的中间变量
            int r=0;
            r=a;a=b;b=r;
        }
        while(true){
            //核心思路，ab求余数，然后循环，余数不为0，a赋值b，b赋值余数,直到a%b==0
            int r=a%b;
            if(r==0){
                System.out.println(c/b);
                break;
            }else{
                a=b;
                b=r;
            }
        }
    }
}
