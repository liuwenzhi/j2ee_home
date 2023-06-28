package com.duomu.hj24;

import java.util.Scanner;

/**
 * 题目描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 *
 * 注意不允许改变队列元素的先后顺序
 * 请注意处理多组输入输出！
 *
 * 输入描述:
 * 整数N
 *
 * 输出描述:
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出
 * 4
 */
public class Main {
    /**
     * 思路：最长递增/递减子序列问题，思路，找出每一个元素对应的最长递增子序列和最长递减子序列，
     * 然后找到某个元素最大递增子序列和最大递减子序列和最大的，用总数-最大值就是最少出列人数
     * 本题可以使用leetcode300题思路
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int total = scanner.nextInt();
            int[] arr = new int[total];
            for(int i = 0 ; i < total ; i++){
                arr[i] = scanner.nextInt();
            }
            int[] l = left(arr);
            int[] r = right(arr);
            int max = 0;
            for(int i = 0 ; i < arr.length ; i++){
                //注意：因为左右侧最大子序列都包含了当前元素本身，所以左右累加的时候，需要去掉本身
                if(max < (l[i]+r[i]-1)){
                    max = l[i]+r[i]-1;
                }
            }
            //总人数减掉最大的左右递增递减子序列之和
            System.out.println(total -max);
        }
    }

    /**
     * 获取数组中每个元素左侧递增序列元素数量（包括当前元素本身）
     * 基于动态规划方式
     */
    public static  int[]  left(int[] arr){
        int[] left = new int[arr.length];
        for(int i =0 ; i < arr.length ; i++){
            left[i] = 1;
            for(int j = 0; j < i ;j++){
                if(arr[j] < arr[i]){
                    left[i] = Math.max(left[i],left[j]+1);
                }
            }
        }
        return left;
    }

    /**
     * 获取数组中每个元素右侧递减元素数量（包括当前元素本身）
     * 基于动态规划方式
     */
    public static  int[]  right(int[] arr){
        int[] right= new int[arr.length];
        for(int i =arr.length-1 ; i >= 0; i--){
            right[i] = 1;
            for(int j = arr.length-1; j >i ;j--){
                if(arr[j] < arr[i]){
                    right[i] = Math.max(right[i],right[j]+1);
                }
            }
        }
        return right;
    }
}
