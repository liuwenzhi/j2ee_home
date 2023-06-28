package com.duomu.hj25;

public class Test {
    public static void main(String[] args){
        String s = "1 2 3 4 5 ";
        //按照空格拆分s，开头有空格会算，末尾有空格不算
        String[] temp = s.split(" ");
        System.out.println(temp.length);
        for(int i=0;i<temp.length;i++){
            System.out.print(temp[i]+",");
        }
    }
}
