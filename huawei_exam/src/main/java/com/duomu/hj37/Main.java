package com.duomu.hj37;

import java.util.Scanner;

/**
 * 题目描述
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *
 *
 * /**
 * * 统计出兔子总数。
 * *
 * * @param monthCount 第几个月
 * * @return 兔子总数
 *
 *public static int getTotalCount(int monthCount)
 *{
 *return 0;
 *}
 *
 *本题有多组数据，请使用while(cin>>)读取
 *
 *
 *输入描述:
 *输入int型表示month
 *
 *输出描述:
 *输出兔子总数int型
 *
 *示例1
 *输入
 *9
 *输出
 *34
 */
public class Main {
    /**本题考察斐波那契数列，一个数列，头两位是1，
     * 从第三位开始，每一个数字是之前两个数字之和*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(getTotalCount1(n));
        }
    }

    /**
     *  基于递归方式实现斐波那契数列
     */
    static int getTotalCount(int monthCount)
    {
        if(monthCount < 3){
            return 1;
        }
        return getTotalCount(monthCount - 2)  + getTotalCount(monthCount - 1) ;
    }

    /**
     * 基于动态规划方式实现斐波那契数列
     * 1、1、2、3、5、8、13、21、34...
     */
    static int getTotalCount1(int monthCount){
        if(monthCount < 3){
            return 1;
        }
        int last = 1;
        int nextToLast = 1;
        int answer = 2;
        //这部分不难理解，把前几次循环的结果自己写出来就能看懂，i从2开始，累加到monthCount-1（实际代表了第3位到第monthCount位，answer可以初始化为0）
        for(int i=2;i<monthCount;i++){
            answer = last+nextToLast;
            //在每次循环的过程中，算好answer的值之后，要把last和nextToLast两个值计算成下一次循环要被累加的值
            nextToLast = last;
            last = answer;
        }
        return answer;
    }
}
