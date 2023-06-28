package com.duomu.hj3;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * TreeSet实现思路
 *
 * 第三题坑很大，注意给set赋值的时候，不能使用这种代码：
 * while(count < num){
 *      set.add(scanner.nextInt());
 *      count ++;
 * }
 * 可能是测试用例有问题，2021你那8月20日二轮刷题复习，上边这种while循环录入就通过了。参考Main2代码
 * 另外不用考虑重复输入多组的情况，测试用例只输入一组。昨天因为输入多组的问题考虑了很长时间。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            TreeSet<Integer> set=new TreeSet<>();
            int n=sc.nextInt();
            if(n>0){
                for(int i=0;i<n;i++){
                    set.add(sc.nextInt());
                }
            }
            for(Integer i:set){
                System.out.println(i);
            }
        }
    }
}