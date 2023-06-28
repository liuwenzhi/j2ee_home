package com.duomu.hj5;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            //parseInt指定进制方式实现转换，需要将入参的格式参数x和xx去掉，0不用去掉
            System.out.println(Integer.parseInt(sc.next().replaceAll("x",""),16));
        }
    }
}
