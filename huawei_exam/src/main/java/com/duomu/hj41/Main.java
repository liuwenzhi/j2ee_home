package com.duomu.hj41;

import java.util.*;
/**
 * 题目描述
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 *
 * 注：
 *
 * 称重重量包括0
 *
 *
 * 方法原型：public static int fama(int n, int[] weight, int[] nums)
 *
 *
 * 输入描述:
 * 输入包含多组测试数据。
 *
 * 对于每组测试数据：
 *
 * 第一行：n --- 砝码数(范围[1,10]) 备注：题目说明有问题：不同类型砝码数量，不是砝码总共的数量
 *
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 *
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 * 输出描述:
 * 利用给定的砝码可以称出的不同的重量数
 *
 * 示例1
 * 输入
 * 复制
 * 2
 * 1 2
 * 2 1
 * 输出
 * 复制
 * 5
 * 备注：本题称的重量包括0
 */
public class Main{

    /**
     * 基于累加思路：
     * 以第一个砝码为基础，在其基础上不断添加，基于示例：
     * 第一个砝码重量为1，数量为2，则三种情况：0，1，2
     * 第二个砝码重量为2，数量为1，则两种情况：0，2
     * 在砝码1的3种的基础上，添加砝码2的两种情况，分别为：0，1，2；2，3，4；去掉重复情况，则为0，1，2，3，4
     * n 砝码数量
     * weight 每个砝码重量集合
     * nums 每个砝码数量集合
     */
    public static int fama(int n, int[] weight, int[] nums){
        Set<Integer> set = new HashSet<>();
        //统计出砝码1的重量情况，砝码1：类型：n=0,数量：num[0]，重量weight[0]
        for(int i = 0; i <= nums[0]; i++){
            set.add(weight[0] * i);
        }
        //之后的统计基于砝码1进行不断累加，循环从i=1开始，即第二个类型的砝码开始
        for(int i = 1; i < n; i++){
            //注意：因为set集合没有get指定位置数据的方法，这里必须要加一步转list的操作，每次循环中list集合不改，set集合改
            List<Integer> list = new ArrayList<>(set);
            //第二层循环是对具体类型的砝码，根据其不同数量进行累加统计，这个循环类似统计砝码1重量那一步，将第i个砝码的全部重量信息都统计到list中已有的重量中
            for(int j = 0; j <= nums[i]; j++){
                //第三层循环进行重量累加，注意这里是weight[i]，即当前遍历的砝码*其对应的数量，最后在第三层循环中和list每一种进行进行组合
                for(int k = 0; k < list.size(); k++){
                    set.add(list.get(k) + j * weight[i]);
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            //不同类型砝码数量
            int n = in.nextInt();
            //砝码重量集合
            int[] weight = new int[n];
            //砝码数量集合
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                weight[i] = in.nextInt();
            }
            for(int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            System.out.println(fama(n, weight, nums));
        }
        in.close();
    }
}
