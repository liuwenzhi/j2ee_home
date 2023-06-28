package com.duomu.hj73;

import java.util.Scanner;

/**
 * 题目描述
 * 根据输入的日期，计算是这一年的第几天。。
 *
 * 详细描述：
 *
 * 输入某年某月某日，判断这一天是这一年的第几天？。
 *
 * 测试用例有多组，注意循环输入
 *
 *
 * 接口设计及说明：
 *
 * /*****************************************************************************
 * Description   : 数据转换
 * Input Param   : year 输入年份
 * Month 输入月份
 * Day 输入天
 *
 * Output Param  :
 * Return Value  : 成功返回0，失败返回-1（如：数据错误）
 * *****************************************************************************
 *public static int iConverDateToDay(int year,int month,int day)
 *{
 * //在这里实现功能，将结果填入输入数组中
 *return 0;
 *}
 *
 * /*****************************************************************************
 * Description   :
 * Input Param   :
 *
 * Output Param  :
 * Return Value  : 成功:返回outDay输出计算后的第几天;
 * 失败:返回-1
 * ****************************************************************************
 *public static int getOutDay()
 *{
 *return 0;
 *}
 *
 *输入描述:
 *输入多行，每行空格分割，分别是年，月，日
 *
 *输出描述:
 *成功:返回outDay输出计算后的第几天;
 *失败:返回-1
 *
 *示例1
 *输入
 *复制
 *2012 12 31
 *输出
 *复制
 *366
 */
public class Main {
    private static int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            System.out.println(iConverDateToDay(year,month,day));
        }
    }

    private static int iConverDateToDay(int year,int month,int day){
        int sum = day;
        for(int i=0;i<month-1;i++){
            sum += monthDay[i];
        }
        if(isLeap(year)&&month>2){
            sum +=1;
        }
        return sum;
    }

    /**判断指定年份是否是闰年*/
    private static boolean isLeap(int year){
        if(year%4==0&&year%100!=0||year%400==0){
            return true;
        }else{
            return false;
        }
    }
}
