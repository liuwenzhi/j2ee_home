package com.duomu.hj22;

import java.util.Scanner;

/**
 * 题目描述
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * 输入描述:
 * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
 *
 * 输出描述:
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 *
 * 示例1
 * 输入
 * 复制
 * 3
 * 10
 * 81
 * 0
 * 输出
 * 复制
 * 1
 * 5
 * 40
 *
 * 备注：本题和leetcode1518题思路类似
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int result = 0;
            int num = scanner.nextInt();
            int temp = num;
            while(temp >= 2){
                if(temp==2){
                    //单独处理一种特殊情况：2个瓶可以向老板借一个瓶子再喝一瓶饮料，结果数加1
                    result++;
                    break;
                }else{
                    //当前temp能兑换的饮料，统计到result中
                    int a = temp/3;
                    result+=a;
                    //temp/3是兑换过来的饮料数量，temp%3是喝完3的倍数瓶饮料之后，剩余的饮料数量，范围在0，1，2三个数之间
                    temp = temp/3+temp%3;
                }
            }
            //2021年9月2日三轮刷题补充：该题优化了测试用例，结果为0不输出
            if(result!=0) {
                System.out.println(result);
            }
        }
    }
}
