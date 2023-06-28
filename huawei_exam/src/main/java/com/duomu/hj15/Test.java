package com.duomu.hj15;

/**
 * 验证下带有符号以及不带有符号的左移和右移
 */
public class Test {
    public static void main(String[] args) {
        //验证下左移1位相当于*2，左移两位相当于*4，左移3位相当于*8，右移1位相当于除以2，备注：<<和>>是带有符号的左移和右移，
        //注意计算机以补码形式保存数字，正数源码、反码和补码都一样，负数反码要除去符号位外取反，补码要在反码基础上再加1，从补码求源码也是除符号位外取反+1
        System.out.println(2<<1);
        System.out.println(4<<1);
        System.out.println(-2<<1);
        System.out.println(-4<<1);
        //带符号右移1位相当于/2，右移两位相当于/4
        System.out.println(2>>1);
        System.out.println(4>>1);
        System.out.println(-2>>1);
        System.out.println(-4>>1);

        System.out.println("--------------------测试不带符号位的移动-----------------------");
        //注意：不带符号的移动，只有右移，没有左移，右移一位相当于除以2
        System.out.println(2>>>1);

        Main main = new Main();
    }
}
