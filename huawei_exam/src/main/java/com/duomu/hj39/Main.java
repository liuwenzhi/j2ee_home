package com.duomu.hj39;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 题目描述
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 *
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　11010000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 *
 * AND运算
 * 11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 *
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 *
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　11010000.10101000.00000000.11111110
 * 子网掩码　11111111.11111111.11111111.00000000
 *
 * AND运算
 * 11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 *
 * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
 *
 *
 * 输入描述:
 * 输入子网掩码、两个ip地址
 *
 * 输出描述:
 * 得到计算结果
 *
 * 示例1
 * 输入
 * 复制
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 输出
 * 复制
 * 1
 * 2
 */
public class Main {

    public static void main(String[] args){
        /**掩码地址数组*/
        int[] aaa = new int[4];
        /**待比较的两个入参ip地址数组*/
        int[] bbb = new int[4];
        int[] ccc = new int[4];
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //a "255.255.255.0"
            String a=scanner.next();
            //b "192.168.224.256"
            String b=scanner.next();
            //c "192.168.10.4"
            String c=scanner.next();
            //aa {"255","255","255","0"}
            String[] aa=a.split("\\.");
            //bb {"192","168","224","256"}
            String[] bb=b.split("\\.");
            //cc {"192","168","10","4"}
            String[] cc=c.split("\\.");
            //aaa {255,255,255,0}
            //int[] aaa=Arrays.stream(aa).mapToInt(Integer::parseInt).toArray();
            for(int i=0;i<4;i++){
                aaa[i] = Integer.parseInt(aa[i]);
            }
            //bbb {192,168,224,256}
            //int[] bbb=Arrays.stream(bb).mapToInt(Integer::parseInt).toArray();
            for(int i=0;i<4;i++){
                bbb[i] = Integer.parseInt(bb[i]);
            }
            //ccc {192.168.10.4}
            //int[] ccc=Arrays.stream(cc).mapToInt(Integer::parseInt).toArray();
            for(int i=0;i<4;i++){
                ccc[i] = Integer.parseInt(cc[i]);
            }
            if(!isIp(bbb)||!isIp(ccc)||!isAd(aaa)){
                System.out.println(1);
                continue;
            }
            boolean flag=true;
            for(int i=0;i<4;i++){
                //直接进行与计算，如果不在同一个网段，直接输出2，跳出循环
                if((bbb[i]&aaa[i])!=(ccc[i]&aaa[i])){
                    System.out.println(2);
                    flag=false;
                    break;
                }
            }
            //如果在同一个网段，则flag的值没有变
            if(flag){
                System.out.println(0);
            }
        }
        scanner.close();
    }

    /**
     * 判断是否是合法的掩码，本题测试用例对掩码的验证不严，不然之前通过不了
     */
    public static boolean isAd(int[] a){
        //获取子网掩码二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toBinaryString(a[0]));
        stringBuilder.append(Integer.toBinaryString(a[1]));
        stringBuilder.append(Integer.toBinaryString(a[2]));
        stringBuilder.append(Integer.toBinaryString(a[3]));
        String maskBinaryString = stringBuilder.toString();
        //子网掩码32位0和32位1都是错的
        if(maskBinaryString.equals("11111111111111111111111111111111")||maskBinaryString.equals("00000000000000000000000000000000")){
            return false;
        }
        //如果子网掩码出现01肯定也是错的，必须前边都是0后边都是1
        if(maskBinaryString.contains("01")){
            return false;
        }
        //保留旧有的子网掩码验证方式
        return a[0]>=0&&a[0]<=255&&
                a[1]>=0&&a[1]<=255&&
                a[2]>=0&&a[2]<=255&&
                a[3]>=0&&a[3]<=255&&
                a[0]>=a[1]&&
                a[1]>=a[2]&&
                a[2]>=a[3];
    }

    /**
     * 判断是否是合法的ip地址，每一位都是0到255
     */
    public static boolean isIp(int[] a){
        return a[0]>=0&&a[0]<=255&&
                a[1]>=0&&a[1]<=255&&
                a[2]>=0&&a[2]<=255&&
                a[3]>=0&&a[3]<=255;
    }
}
