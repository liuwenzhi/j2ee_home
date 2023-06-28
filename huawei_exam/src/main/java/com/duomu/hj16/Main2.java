package com.duomu.hj16;

import java.util.Scanner;

/**
 * 在Main1基础上对Main进行第二次优化，用一维商品数组代替HashMap集合
 * 空间和时间优化不是太多
 * 2021你那8月21日，继续对一维数组遍历进行优化，基于商品价格都是10的倍数，遍历一维数组的for循环条件中，让j每次累计减10
 * for：int j = totalMoney; j >=10; j-=10
 * 时间效率一下子提高了一半以上，从94ms到49ms
 */
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //花费总钱数
            int totalMoney = scanner.nextInt();
            //购买总数量
            int totalNum = scanner.nextInt();
            //定义一个商品数组，注意因为实际商品从1开始编号，这个数组定义长度为totalNum+1,0位置是无效元素，把googs长度定义成0后边附件不好处理
            Good[] goods = new Good[totalNum+1];
            for(int i=1;i<=totalNum;i++){
                goods[i] = new Good();
                goods[i].v = Integer.parseInt(scanner.next());
                goods[i].p = Integer.parseInt(scanner.next());
                goods[i].q = Integer.parseInt(scanner.next());
                //单独处理下附件的情况
                if(goods[i].q > 0){
                    //对应主件还没赋值附件1就给附件1传值
                    if(goods[goods[i].q].sub1==0){
                        goods[goods[i].q].sub1 = i;
                    }else{
                        //对应主件的附件1已经赋值的情况下给附件2赋值
                        goods[goods[i].q].sub2 = i;
                    }
                }
            }
            System.out.println(getMaxValue(totalMoney,totalNum,goods));
        }
    }

    /**计算乘积最大值*/
    private static int getMaxValue(int totalMoney,int totalNum,Good[] goods) {
        //定义01背包一维数组缓存，01背包从0开始计算，列会比实际多一列
        int[] value = new int[totalMoney + 1];
        for (int i = 1; i <= totalNum; i++) {
            //定义主件，主件和附件1，主件和附件2，主件和附件1和附件2四个最终价值变量
            int valueMain, valueMainSub1 = 0, valueMainSub2 = 0, valueMainSub1Sub2 = 0;
            //定义主件，主件和附件1，主件和附件2，主件和附件1和附件2四个价格变量
            int moneyMain, moneyMainSub1 = 0, moneyMainSub2 = 0, moneyMainSub1Sub2 = 0;
            //只有主件
            moneyMain = goods[i].v;
            valueMain = goods[i].v * goods[i].p;
            //主件和附件1
            if (goods[i].sub1 != 0) {
                moneyMainSub1 = moneyMain + goods[goods[i].sub1].v;
                valueMainSub1 = valueMain + goods[goods[i].sub1].v * goods[goods[i].sub1].p;
            }

            //主件和附件2
            if (goods[i].sub2 != 0) {
                moneyMainSub2 = moneyMain + goods[goods[i].sub2].v;
                valueMainSub2 = valueMain + goods[goods[i].sub2].v * goods[goods[i].sub2].p;
            }

            //主件和附件1，附件2
            if (goods[i].sub1 != 0 && goods[i].sub2 != 0) {
                moneyMainSub1Sub2 = moneyMain + goods[goods[i].sub1].v + goods[goods[i].sub2].v;
                valueMainSub1Sub2 = valueMain + goods[goods[i].sub1].v * goods[goods[i].sub1].p + goods[goods[i].sub2].v * goods[goods[i].sub2].p;
            }
            //用一维动态规划数组从后往前遍历，因为钱都是10的整数倍，规划的时候以10为间隔，这样就大量减少了计算
            for (int j = totalMoney; j >=10; j-=10) {
                if (goods[i].q > 0) {
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


