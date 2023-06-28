package com.duomu.hj30;

import java.util.*;
public class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str_1= sc.next();
            String str_2 = sc.next();
            String str = str_1+str_2;
            //使用字符串，将转换关系对应如下
            String st1 = "abcedfABCEDF0123456789";
            String st2 = "5D37BF5D37BF084C2A6E19";
            System.out.println(strChange(strSort(str),st1,st2));
        }
    }
    //字符串转换函数，将排序好的字符串进行相应转换
    public static String strChange(String str,String s1,String s2){
        char data[] = str.toCharArray();
        for(int i = 0;i<data.length;i++){
            if('0'<=data[i]&&data[i]<='9'||'A'<=data[i]&&data[i]<='F'||'a'<=data[i]&&data[i]<='f'){
                for(int j=0;j<s2.length();j++){
                    if(data[i]==s1.charAt(j)){
                        data[i]=s2.charAt(j);
                        break ;
                    }
                }
            }
        }
        return new String(data);
    }
    //使用两个数组存储按奇数偶数排序后的两个字符数组
    public static String strSort(String str){
        char data1[] = new char[str.length()];
        char data2[] = new char[str.length()];
        String sb = "";
        int j=0;
        int m=0;
        for(int i = 0;i<str.length();i++){
            if(i%2==0){
                data1[j++]=str.charAt(i);
            }else if(i%2==1)
                data2[m++]=str.charAt(i);
        }
        Arrays.sort(data1);
        Arrays.sort(data2);
        for(int i = 0;i<str.length();i++){
            sb+=(i%2==0)?data1[m++]:data2[j++];
        }
        return sb;
    }
}
