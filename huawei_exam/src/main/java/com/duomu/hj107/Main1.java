package com.duomu.hj107;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[]args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        double input=Double.parseDouble(br.readLine());
        boolean flag=false;
        if(input<0) {
            flag=true;
            input=-input;
        }
        double distance=input;//误差或者增加的距离
        double index=0;
        double last=0;
        while(true) {
            last=index*index*index;
            if(last>input) {
                index-=distance;
                distance/=10;
            }
            //误差在这个范围内，跳出循环
            if(distance<0.001) {
                break;
            }
            index+=distance;
        }
        double result=(int)((index+0.05)*10)/10.0;
        if(flag) {
            result=0-result;
        }
        System.out.println(result);
    }
}
