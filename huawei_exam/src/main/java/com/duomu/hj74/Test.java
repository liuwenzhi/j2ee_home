package com.duomu.hj74;

public class Test {
    public static void main(String[] args){
        //注意：下边这种情况进行数组拆分，得到的结果中数组有5个元素，不是4个元素，在第一个|之前还有一个空元素
        String s[] = "|123|456|789|123".split("\\|");
        System.out.println(s.length);
        for(String s1:s){
            System.out.println(s1);
        }
    }
}
