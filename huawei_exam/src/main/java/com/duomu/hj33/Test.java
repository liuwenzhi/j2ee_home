package com.duomu.hj33;

public class Test {
    public static void main(String[] args){
        //将10这个字符串，按照2进制的形式转成整数，输出结果2
        System.out.println(Integer.parseInt("10", 2));
        //将10这个字符串，按照10进制的形式转成整数，输出结果10
        System.out.println(Integer.parseInt("10",10));
        //将F这个字符串按照16进制转成整数，输出结果15
        System.out.println(Integer.parseInt("F",16));
        /*左移几 就是乘以 2的几次方 左移三位 就是 乘以8
            右移几 就是除以 2的几次方*/
        System.out.println(3 << 8);
    }
}
