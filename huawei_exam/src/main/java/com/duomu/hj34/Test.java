package com.duomu.hj34;

public class Test {
    public static void main(String[] args){
        //查看字符的ASCII码
        System.out.println((int)'0');
        System.out.println((int)'A');
        System.out.println((int)'a');
        //通过ASCII码查看对应的字符
        for(int i=48;i<120;i++){
            System.out.println((char)i);
        }
    }
}
