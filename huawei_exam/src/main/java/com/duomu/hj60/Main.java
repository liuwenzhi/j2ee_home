package com.duomu.hj60;

import java.util.Scanner;
/**
 * 题目描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对
 * 输入描述:
 * 输入一个偶数
 * 输出描述:
 * 输出两个素数
 * 示例1
 * 输入
 * 20
 * 输出
 * 7
 * 13
 */
public class Main {
    /**
     * 知识点备份：素数与质数一样。
     * 质数（又称素数），是指在大于1的自然数中，除了1和它本身外，不能被其他自然数整除（除0以外）的数称之为素数（质数）。比1大但不是素数的数称为合数，1和0既非素数也非合数。
     * 素数不是奇数。奇数是不能被2整除的数。比如9是奇数，但不是素数。因为9不能被2整除，所以是奇数，但9有1、3、9三个因数，所以不是素数。
     * 本题思路记一下，从这个偶数的中间位置开始往两边去找，如果输入是4，则这个素数对是2和2，结果两个数字可以重复
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            //输入为偶数，直接从中间开始找，注意一个细节：要找的两个素数，到这个偶数*1/2的值的距离一样
            int start = num/2,end = num/2;
            //0和1不是素数也不是合数，2是素数
            while(start>2 && end<(num-2)){
                if(isPrime(start)&&isPrime(end)){
                    break;
                }else{
                    start--;
                    end++;
                }
            }
            System.out.println(start);
            System.out.println(end);
        }
        scanner.close();
    }

    /**
     * 判断一个数是不是素数（质数）
     */
    private static boolean isPrime(int num){
        //第六题采用这个方式设计for循环：int i = 2; i <= Math.sqrt(num); i++，效率和本题基本一致
        for (int i = 2; i <= num/i; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
