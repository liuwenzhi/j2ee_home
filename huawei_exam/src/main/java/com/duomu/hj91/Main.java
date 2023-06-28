package com.duomu.hj91;

/**
 * 题目描述
 * 请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，
 * 总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * 输入描述:
 * 输入两个正整数
 *
 * 输出描述:
 * 返回结果
 *
 * 示例1
 * 输入
 * 2
 * 2
 * 输出
 * 6
 */
import java.util.Scanner;
public class Main {
    /*f(n,m)表示n*m矩阵的走法，第一步可以往下走，走了之后矩阵变成(n-1)*m，也可以往右走，
    矩阵就变成n*(m-1)，所以f(n,m)=f(n-1,m)+f(n,m-1)，明显的递归式。*/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(func(n,m));
        }
    }
    /*采用递归方式求解*/
    private static int func(int n,int m){
        //如果横向或者纵向触碰边界，则只有一种走法
        if(n==0||m==0){
            return 1;
        }
        //从横向和纵向两个方面来递归方法
        return func(n-1,m)+func(n,m-1);
    }
}
