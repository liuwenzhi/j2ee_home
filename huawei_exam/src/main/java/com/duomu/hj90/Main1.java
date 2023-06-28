package com.duomu.hj90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            System.out.println(checkIp(line));
        }
    }
    private static String checkIp(String ip){
        //ip地址包含空格，报错，这个可以不加
        if(ip.contains(" ")){
            return "NO";
        }
        String[] ipPart = ip.split("\\.");
        //Ip地址没有点分四位，报错
        if(ipPart.length!=4){
            return "NO";
        }

        //ip地址点分的每一段，没有在0到255之间，报错
        if(!(checkNum(ipPart[0])&&checkNum(ipPart[1])&&checkNum(ipPart[2])&&checkNum(ipPart[3]))){
            return "NO";
        }
        //全部验证都通过，正确
        return "YES";
    }

    private static boolean checkNum(String num){
        if(Integer.parseInt(num)>255||Integer.parseInt(num)<0){
            return false;
        }
        return true;
    }
}
