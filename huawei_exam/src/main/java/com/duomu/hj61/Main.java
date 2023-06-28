package com.duomu.hj61;
import java.util.Scanner;

/**
 * 题目描述
 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 * 输入
 * 每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
 * 样例输入
 * 7 3
 * 样例输出
 * 8
 * * 计算放苹果方法数目
 * * 输入值非法时返回-1
 * * 1 <= m,n <= 10
 * * @param m 苹果数目
 * * @param n 盘子数目数
 * * @return 放置方法总数
 *public static int count(int m,int n)
 *输入描述:
 *输入两个int整数
 *输出描述:
 *输出结果，int型
 *示例1
 *输入
 *7 3
 *输出
 *8
 */
public class Main {
    /**
     * 注意题干中核心的点：m个相同的苹果，n个相同的盘子，求的是一个组合，不是排列
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int result = -1;
            //苹果数
            int m = scanner.nextInt();
            //盘子数
            int n = scanner.nextInt();
            if(m>=1&&m<=10&&n>=1&&n<=10){
                result = apples(m,n);
            }
            System.out.println(result);
        }
    }

    /**
     * 放苹果分为两种情况，一种是有盘子为空，一种是每个盘子上都有苹果。
     * 令(m,n)表示将m个苹果放入n个盘子中的摆放方法总数。
     * 1.假设有一个盘子为空，则(m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
     * 2.假设所有盘子都装有苹果，则每个盘子上至少有一个苹果，即最多剩下m-n个苹果，问题转化为将m-n个苹果放到n个盘子上
     * 即求(m-n，n)
     * 综上所述：
     * (m，n)=(m,n-1)+(m-n,n);
     */
    private static int apples(int m,int n){
        //递归计算中涉及到进行相减运算，m是被减数，增加下对小于0时候的控制
        if(m<0||n<=0){
            return 0;
        }
        //只有1个盘子或者只有1个苹果，则只有一种分法
        if(m==1||n==1){
            return 1;
        }
        //拆分成两个部分：至少一个盘子为空，全部盘子都有苹果（每个盘子拿走一个对结果没有影响，注意不能直接递归apples(m,n)）
        return apples(m,n-1)+apples(m-n,n);
    }

    /**
     * 解题分析：
     *         设f(m,n) 为m个苹果，n个盘子的放法数目，则先对n作讨论，
     *         当n>m：必定有n-m个盘子永远空着，去掉它们对摆放苹果方法数目不产生影响。即if(n>m) f(m,n) = f(m,m)　　
     *         当n<=m：不同的放法可以分成两类：
     *         1、有至少一个盘子空着，即相当于f(m,n) = f(m,n-1);
     *         2、所有盘子都有苹果，相当于可以从每个盘子中拿掉一个苹果，不影响不同放法的数目，即f(m,n) = f(m-n,n).
     *         而总的放苹果的放法数目等于两者的和，即 f(m,n) =f(m,n-1)+f(m-n,n)
     *     递归出口条件说明：
     *         当n=1时，所有苹果都必须放在一个盘子里，所以返回１；
     *         当没有苹果可放时，定义为１种放法；
     *         递归的两条路，第一条n会逐渐减少，终会到达出口n==1;
     *         第二条m会逐渐减少，因为n>m时，我们会return f(m,m)　所以终会到达出口m==0．
     */
    private static int apples1(int m,int n){
        //因为我们总是让m>=n来求解的，所以m-n>=0,所以让m=0时候结束，如果改为m=1，则可能出现m-n=0的情况从而不能得到正确解
        if(m==0||n==1){
            return 1;
        }
        if(n>m){
            return apples1(m,m);
        }else{
            return apples1(m,n-1)+apples1(m-n,n);
        }
    }
}
