package com.duomu.hj33;
import java.util.*;
/**
 * 遇到的问题，数组越界，输入格式不正确，应都为String输入；
 * int型溢出，要换为long型
 */
public class Main1 {
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String ip=in.nextLine();
            String p=in.nextLine();
            System.out.println(IptoTen(ip));
            TentoIp(p);
        }
    }

    /**
     * 十进制数字转IP地址
     */
    private static void TentoIp(String p) {
        //整形ip地址转成long
        long temp=Long.parseLong(p);
        //long型IP地址转成二进制字符串
        String ip=Long.toBinaryString(temp);
        //long型ip地址转成二进制字符串之后进行补位，补齐32位
        StringBuilder sb=new StringBuilder();
        if(ip.length()<32){
            for(int i=0;i<(32-ip.length());i++){
                sb.append(0);
            }
            sb.append(ip);
        }else if(ip.length()==32){
            sb.append(ip);
        }
        //8
        for(int i=0;i<sb.length()-8;i=i+8){
            //备注：Integer.parseInt("10", 2)，第二个参数代表进制
            System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
        }

        //最后8位转成二进制
        System.out.println(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));

    }

    /**
     * IP地址转十进制数字
     */
    private static long IptoTen(String ip) {
        String[] arr=ip.split("\\.");
        long n=Long.parseLong(arr[0]);

        for(int i=1;i<arr.length;i++){
            //左移8位相当于*2的8次幂，右移8位相当于除以2的8次幂，注意arr数组中下标小的是高位
            n=n<<8;
            n=n+Long.parseLong(arr[i]);
        }

        return n;
    }
}
