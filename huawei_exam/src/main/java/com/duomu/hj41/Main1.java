package com.duomu.hj41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 基于Main方法对输入输出进行改造。改了之后效率能高很多。注意BufferedRead使用readLine来获取值，
 * 获取成字符串的再通过类型去转。
 */
public class Main1 {

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
            //第二层循环是对具体类型的砝码，根据其不同数量进行累加统计，这个循环类似统计砝码1重量那一步
            for(int j = 0; j <= nums[i]; j++){
                //第三层循环进行重量累加，注意这里是weight[i]，第i类砝码重量一致，不要弄混。
                for(int k = 0; k < list.size(); k++){
                    set.add(list.get(k) + j * weight[i]);
                }
            }
        }
        return set.size();
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            //不同类型砝码数量
            int n = Integer.parseInt(line);
            String[] weight1 = br.readLine().split(" ");
            String[] nums1 = br.readLine().split(" ");
            //砝码重量集合
            int[] weight = new int[n];
            //砝码数量集合
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                weight[i] = Integer.parseInt(weight1[i]);
            }
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(nums1[i]);
            }
            System.out.println(fama(n, weight, nums));
        }
    }
}
