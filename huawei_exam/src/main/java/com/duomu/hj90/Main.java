package com.duomu.hj90;

import java.util.Scanner;

/**
 * 题目描述
 * 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），
 * 如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 *
 * 现在需要你用程序来判断IP是否合法。
 *
 *
 * 输入描述:
 * 输入一个ip地址
 *
 * 输出描述:
 * 返回判断的结果YES or NO
 *
 * 示例1
 * 输入
 * 10.138.15.1
 * 输出
 * YES
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String ip = scanner.nextLine();
            System.out.println(checkIp(ip));
        }
        scanner.close();
    }
    private static String checkIp(String ip){
        //ip地址包含空格，报错
        if(ip.contains("\\s+")){
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
