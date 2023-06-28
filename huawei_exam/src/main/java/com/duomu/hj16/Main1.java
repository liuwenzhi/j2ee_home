package com.duomu.hj16;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 对Main的第一次优化，将01背包二维动态规划数组优化成一维数组，同时优化最后一次遍历，
 * 耗时从128ms提升到94ms
 */
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //花费总钱数
            int totalMoney = scanner.nextInt();
            //购买总数量
            int totalNum = scanner.nextInt();
            //map集合中，i存放上边编号，安题意从1开始
            HashMap<Integer,Good> map = new HashMap<>(totalNum);
            for(int i=1;i<=totalNum;i++){
                Good good = new Good();
                good.v = scanner.nextInt();
                good.p = scanner.nextInt();
                good.q = scanner.nextInt();
                //单独处理下附件的情况
                if(good.q > 0){
                    //对应主件还没赋值附件1就给附件1传值
                    if(map.get(good.q).sub1==0){
                        map.get(good.q).sub1 = i;
                    }else{
                        //对应主件的附件1已经赋值的情况下给附件2赋值
                        map.get(good.q).sub2 = i;
                    }
                }
                map.put(i,good);
            }
            System.out.println(getMaxValue(totalMoney,totalNum,map));
        }
    }

    /**计算乘积最大值*/
    private static int getMaxValue(int totalMoney,int totalNum,HashMap<Integer,Good> map) {
        //定义01背包一维数组缓存
        int[] value = new int[totalMoney + 1];
        for (int i = 1; i <= totalNum; i++) {
            //定义主件，主件和附件1，主件和附件2，主件和附件1和附件2四个最终价值变量
            int valueMain, valueMainSub1 = 0, valueMainSub2 = 0, valueMainSub1Sub2 = 0;
            //定义主件，主件和附件1，主件和附件2，主件和附件1和附件2四个价格变量
            int moneyMain, moneyMainSub1 = 0, moneyMainSub2 = 0, moneyMainSub1Sub2 = 0;
            Good good = map.get(i);
            //只有主件
            moneyMain = good.v;
            valueMain = good.v * good.p;
            //主件和附件1
            if (good.sub1 != 0) {
                moneyMainSub1 = moneyMain + map.get(good.sub1).v;
                valueMainSub1 = valueMain + map.get(good.sub1).v * map.get(good.sub1).p;
            }

            //主件和附件2
            if (good.sub2 != 0) {
                moneyMainSub2 = moneyMain + map.get(good.sub2).v;
                valueMainSub2 = valueMain + map.get(good.sub2).v * map.get(good.sub2).p;
            }

            //主件和附件1，附件2
            if (good.sub1 != 0 && good.sub2 != 0) {
                moneyMainSub1Sub2 = moneyMain + map.get(good.sub1).v + map.get(good.sub2).v;
                valueMainSub1Sub2 = valueMain + map.get(good.sub1).v * map.get(good.sub1).p + map.get(good.sub2).v * map.get(good.sub2).p;
            }
            //用一维动态规划数组从后往前遍历
            for (int j = totalMoney; j >=10; j-=10) {
                if (good.q > 0) {
                    //当物品i是附件时,相当于跳过
                    continue;
                } else {
                    //需要对单独一个主件，主件+附件1，主件+附件2，主件+附件1+附件2四种情况进行判断，找到一个最大值
                    if (moneyMain != 0 && j >= moneyMain) {
                        value[j] = Math.max(value[j], value[j - moneyMain] + valueMain);
                    }
                    if (moneyMainSub1 != 0 && j >= moneyMainSub1) {
                        value[j] = Math.max(value[j], value[j - moneyMainSub1] + valueMainSub1);
                    }
                    if (moneyMainSub2 != 0 && j >= moneyMainSub2) {
                        value[j] = Math.max(value[j], value[j - moneyMainSub2] + valueMainSub2);
                    }
                    if (moneyMainSub1Sub2 != 0 && j >= moneyMainSub1Sub2) {
                        value[j] = Math.max(value[j], value[j - moneyMainSub1Sub2] + valueMainSub1Sub2);
                    }
                }
                //如果动态规划走到了最后一行最后一列，则计算完这一列之后就退出，不去计算最后一行之前的列了
                if(i==totalNum&&j==1){
                    break;
                }
            }
        }
        //01背包计算缓存的最后一个元素是最终结果
        return value[totalMoney];
    }

}


