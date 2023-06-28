package com.duomu.hj35;

import java.util.Scanner;

/**
 * 题目描述
 * 题目说明
 *
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 样例输入
 *
 * 5
 *
 * 样例输出
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 *
 * 接口说明
 *
 * 原型
 *
 * void GetResult(int Num, char * pResult);
 *
 * 输入参数：
 *
 *         int Num：输入的正整数N
 *
 * 输出参数：
 *
 *         int * pResult：指向存放蛇形矩阵的字符串指针
 *
 *         指针指向的内存区域保证有效
 *
 * 返回值：
 *
 *         void
 * 输入描述:
 * 输入正整数N（N不大于100）
 *
 * 输出描述:
 * 输出一个N行的蛇形矩阵。
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * 输出
 * 复制
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            int cache[] = new int[num];
            int start = 1;
            int temp = 2;
            //构建第一行
            cache[0] = start;
            System.out.print(cache[0]+" ");
            for(int i=1;i<num;i++){
                cache[i] = cache[i-1] + temp;
                System.out.print(cache[i]+" ");
                temp++;
            }
            System.out.println();
            //构建其余行，每一行相当于上一行多一列对应位置那个元素减去1，直接针对于第一行来构建其他行
            for(int i=1;i<num;i++){
                for(int j=i;j<num;j++){
                    //外层for循环相当于行，内层for循环相当于列，cache数组代表第一行的元素，直接拿这个来-i，一层一层计算
                    System.out.print((cache[j]-i)+" ");
                }
                //输出完一行进行换行
                System.out.println();
            }
        }
    }
}
