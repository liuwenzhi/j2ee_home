package com.duomu.hj38;

import java.util.Scanner;

/**
 * 题目描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 * 最后的误差判断是小数点6位
 *
 *
 *
 * 输入描述:
 * 输入起始高度，int型
 *
 * 输出描述:
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 *
 * 示例1
 * 输入
 * 复制
 * 1
 * 输出
 * 复制
 * 2.875
 * 0.03125
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int height = scanner.nextInt();
            double d = height;
            //总轨迹长度变量
            double totalLine = 0;
            int i=1;
            while(i<=5){
                if(i==1){
                    //第一次落地轨迹没有重复
                    totalLine += d;
                }else{
                    //第二次落地开始每一次弹起和落地相当于有一次重复的轨迹
                    totalLine += 2*d;
                }
                //第i次落地后反弹的高度
                d = d/2;
                i++;
            }
            //总共运行轨迹
            System.out.println(totalLine);
            //最后一次反弹高度
            System.out.println(d);
        }
    }
}
