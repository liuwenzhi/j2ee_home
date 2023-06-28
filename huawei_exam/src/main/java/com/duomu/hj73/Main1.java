package com.duomu.hj73;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    private static int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            String[] temp = line.split(" ");
            int year = Integer.parseInt(temp[0]);
            int month = Integer.parseInt(temp[1]);
            int day = Integer.parseInt(temp[2]);
            System.out.println(iConverDateToDay(year,month,day));
        }
    }

    private static int iConverDateToDay(int year,int month,int day){
        int sum = day;
        for(int i=0;i<month-1;i++){
            sum += monthDay[i];
        }
        //for循环先按照正常平年统计天数，如果是闰年b并且月份大于2再加一天，2021年9月2日三轮测试，发现之前的算法：新增用例：2000 2 1通过不了
        if(isLeap(year)&&month>2){
            sum +=1;
        }
        return sum;
    }

    /**判断指定年份是否是闰年*/
    private static boolean isLeap(int year){
        if(year%4==0&&year%100!=0||year%400==0){
            return true;
        }else{
            return false;
        }
    }

}
