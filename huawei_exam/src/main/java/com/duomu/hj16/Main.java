package com.duomu.hj16;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件  附件
 * 电脑  打印机，扫描仪
 * 书柜  图书
 * 书桌  台灯，文具
 * 工作椅 无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，
 * 他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，
 * 使每件物品的价格与重要度的乘积的总和最大。
 *     设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
 * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
 *     请你帮助王强设计一个满足要求的购物单。
 *
 *
 *
 *
 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 *
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 *
 *
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 *
 *
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 *
 *
 *
 *
 * 输出描述:
 *  输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 * 示例1
 * 输入
 *
 * 1000 5
 * 800 2 0
 * 400 5 1
 * 300 5 1
 * 400 3 0
 * 500 2 0
 * 输出
 *
 * 2200
 *
 * 6000 15
 * 100 3 0
 * 400 5 0
 * 300 5 0
 * 1400 2 3
 * 500 2 2
 * 800 2 3
 * 1400 5 0
 * 300 5 0
 * 1400 3 0
 * 500 2 0
 * 1800 4 0
 * 440 5 10
 * 1340 5 10
 * 430 3 0
 * 500 2 0
 *
 */
public class Main {
    /**
     * 本地考察景点01背包算法，参考学习材料：
     * 背包问题入门级理解
     * https://blog.csdn.net/huyang0304/article/details/82286279
     *
     * 背包问题深入理解
     * https://blog.csdn.net/lanyu_01/article/details/79815801
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //花费总钱数
            int totalMoney = scanner.nextInt();
            //购买总数量
            int totalNum = scanner.nextInt();
            Map<Integer,Good> map = new HashMap<>(totalNum);
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
    private static int getMaxValue(int totalMoney,int totalNum,Map<Integer,Good> map){
        //定义01背包二位数组缓存
        int[][] value = new int[totalNum+1][totalMoney+1];
        for(int i=1;i<=totalNum;i++){
            //定义主件，主件和附件1，主件和附件2，主件和附件1和附件2四个最终价值变量
            int valueMain,valueMainSub1=0,valueMainSub2=0,valueMainSub1Sub2=0;
            //定义主件，主件和附件1，主件和附件2，主件和附件1和附件2四个价格变量
            int moneyMain,moneyMainSub1=0,moneyMainSub2=0,moneyMainSub1Sub2=0;
            Good good = map.get(i);
            //只有主件
            moneyMain = good.v;
            valueMain = good.v * good.p;
            //主件和附件1
            if(good.sub1!=0){
                moneyMainSub1 = moneyMain+map.get(good.sub1).v;
                valueMainSub1 = valueMain+map.get(good.sub1).v*map.get(good.sub1).p;
            }

            //主件和附件2
            if(good.sub2!=0){
                moneyMainSub2 = moneyMain+map.get(good.sub2).v;
                valueMainSub2 = valueMain+map.get(good.sub2).v*map.get(good.sub2).p;
            }

            //主件和附件1，附件2
            if(good.sub1!=0&&good.sub2!=0){
                moneyMainSub1Sub2 = moneyMain+map.get(good.sub1).v+map.get(good.sub2).v;
                valueMainSub1Sub2 = valueMain+map.get(good.sub1).v*map.get(good.sub1).p+map.get(good.sub2).v*map.get(good.sub2).p;
            }
            for(int j=1;j<=totalMoney;j++){
                if(good.q > 0) {
                    //当物品i是附件时,相当于跳过
                    value[i][j] = value[i-1][j];
                } else {
                    //注意：这一步很必要，因为下边四个if可能都不走
                    value[i][j] = value[i-1][j];
                    if(moneyMain!=0&&j>=moneyMain){
                        value[i][j] = Math.max(value[i][j],value[i-1][j-moneyMain]+valueMain);
                    }
                    if(moneyMainSub1!=0&&j>=moneyMainSub1){
                        value[i][j] = Math.max(value[i][j],value[i-1][j-moneyMainSub1]+valueMainSub1);
                    }
                    if(moneyMainSub2!=0&&j>=moneyMainSub2){
                        value[i][j] = Math.max(value[i][j],value[i-1][j-moneyMainSub2]+valueMainSub2);
                    }
                    if(moneyMainSub1Sub2!=0&&j>=moneyMainSub1Sub2){
                        value[i][j] = Math.max(value[i][j],value[i-1][j-moneyMainSub1Sub2]+valueMainSub1Sub2);
                    }
                }
            }
        }
        //01背包计算缓存的最后一个元素是最终结果
        return value[totalNum][totalMoney];
    }

    /**
     * 自定义静态内部商品类
     * 备注：创建好的商品对象都放到统一的集合里边（Map或者数组，封装商品接口是不用考虑编号问题）
     */
    private static class Good{
        /**价格，10的整数倍*/
        private int v;
        /**重要程度，1到5*/
        private int p;
        /**主件和附件标识属性，主件：0，附件：主键编号*/
        private int q;
        /**附件1编号*/
        private int sub1;
        /**附件2编号*/
        private int sub2;
    }
}
