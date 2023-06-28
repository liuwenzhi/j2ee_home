package com.duomu.hj62;

public class Test {
    public static void main(String[] args){
        //将十进制数转成二进制字符串，例如n=5 ，s = "101"
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.parseInt("123"));
        //将10按照10进制数字转成对应的十进制数字
        System.out.println(Integer.parseInt("123",10));
        //将10按照2进制数字转成对应的十进制数字
        System.out.println(Integer.valueOf("10",2));
        //将10按照16进制数字转成对应的十进制数字
        System.out.println(Integer.valueOf("10",16));
    }
}
