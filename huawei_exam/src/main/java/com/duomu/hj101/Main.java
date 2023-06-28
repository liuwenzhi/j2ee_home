package com.duomu.hj101;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
 *
 * 接口说明
 *
 * 原型：
 *
 * void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag);
 *
 * 输入参数：
 *
 * Integer[] pIntegerArray：整型数组
 *
 * int  iSortFlag：排序标识：0表示按升序，1表示按降序
 *
 * 输出参数：
 *
 * 无
 *
 * 返回值：
 *
 * void
 *
 * 本题有多组输入，请使用while(cin>>)处理
 *
 * 输入描述:
 * 1、输入需要输入的整型数个数
 *
 * 输出描述:
 * 输出排好序的数字
 *
 * 示例1
 * 输入
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 输出
 * 1 2 3 4 9 25 55 64
 */
public class Main {
    /**支持升序排序的静态内部类*/
    private static class Increase implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }
    /**支持降序排序的静态内部类*/
    private static class Decrease implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
    /**本题和hj68题类似*/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //元素总数
            int num = scanner.nextInt();
            Integer temp[] = new Integer[num];
            //录入排序数组
            for(int i=0;i<num;i++){
                temp[i] = scanner.nextInt();
            }
            int sort = scanner.nextInt();
            //排序方式，备注：这里直接用Arrays.sort会比这下边编码方式慢
            if(sort==0){
                Arrays.sort(temp,new Increase());
            }else{
                Arrays.sort(temp,new Decrease());
            }
            for(int i=0;i<temp.length;i++){
                System.out.print(temp[i]+" ");
            }
            System.out.println();
        }
    }
}
