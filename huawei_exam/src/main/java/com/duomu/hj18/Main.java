package com.duomu.hj18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 *
 * 所有的IP地址划分为 A,B,C,D,E五类，注意：题目中给出的ABCDE五类地址，是具体的ip地址，~ 后边不是子网掩码，包括后边的私有IP范围也是具体IP地址
 *
 * A类地址1.0.0.0~126.255.255.255;
 *
 * B类地址128.0.0.0~191.255.255.255;
 *
 * C类地址192.0.0.0~223.255.255.255;
 *
 * D类地址224.0.0.0~239.255.255.255；
 *
 * E类地址240.0.0.0~255.255.255.255
 *
 *
 * 私网IP范围是：
 *
 * 10.0.0.0～10.255.255.255
 *
 * 172.16.0.0～172.31.255.255
 *
 * 192.168.0.0～192.168.255.255
 *
 *
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * 注意二进制下全是1或者全是0均为非法
 *
 * 注意：
 * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 *
 * 输入描述:
 * 多行字符串。每行一个IP地址和掩码，用~隔开。
 *
 * 输出描述:
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 *
 * 示例1
 * 输入
 * 复制
 * 10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 * 输出
 * 复制
 * 1 0 1 0 0 2 1
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> ipList = new ArrayList<>();
        while(scanner.hasNext()){
            //本题这里也可以改成scanner.next()，但是效率没有nextLine()高
            String line = scanner.nextLine();
            ipList.add(line);
        }
        System.out.println(getIpAndMaskInfo(ipList));
        scanner.close();
    }

    /**
     * 执行流程：判断ip地址是否正确，判断掩码是否正确，统计各类ip地址个数和私有ip地址个数
     * 备注说明：没有判断子网掩码的二进制标识必须是1开头，没有判断ip地址中每一段为负数或者大于255的情况，然后如果ip地址和掩码都错误算一个，
     * 如果ip地址正确，掩码错误，也算错误，不用对ip地址进行统计，这个题里边坑很多。
     */
    private static String getIpAndMaskInfo(List<String> ipList){
        //ABCDE类地址个数
        int ipA=0,ipB=0,ipC=0,ipD=0,ipE=0;
        //错误ip地址个数
        int ipOrMaskError=0;
        //私有ip地址个数
        int privateIp=0;
        for(String ipInfo:ipList){
            String ip = ipInfo.substring(0,ipInfo.indexOf("~"));
            String mask = ipInfo.substring(ipInfo.indexOf("~")+1);
            int ipPart1,ipPart2,ipPart3,ipPart4;
            String ipTemp[] = ip.split("\\.");
            try {
                ipPart1 = Integer.parseInt(ipTemp[0]);
                ipPart2 = Integer.parseInt(ipTemp[1]);
                ipPart3 = Integer.parseInt(ipTemp[2]);
                ipPart4 = Integer.parseInt(ipTemp[3]);
            }catch(Exception e){
                ipOrMaskError ++;
                //这里有个坑，如果一个地址ip和掩码都错误，算一个，不算俩，这里出现异常就直接跳到下一个循环判断下一个ip地址
                continue;
            }
            int maskPart1,maskPart2,maskPart3,maskPart4;
            String maskString;
            String maskTemp[] = mask.split("\\.");
            try{
                maskPart1 = Integer.parseInt(maskTemp[0]);
                maskPart2 = Integer.parseInt(maskTemp[1]);
                maskPart3 = Integer.parseInt(maskTemp[2]);
                maskPart4 = Integer.parseInt(maskTemp[3]);
                maskString = leftSide8(Integer.toBinaryString(maskPart1))
                        +leftSide8(Integer.toBinaryString(maskPart2))+leftSide8(Integer.toBinaryString(maskPart3))
                        +leftSide8(Integer.toBinaryString(maskPart4));
            }catch(Exception e){
                ipOrMaskError ++;
                continue;
            }
            //子网掩码全是1 非法
            if (maskString.lastIndexOf("1") == maskString.length()-1){
                ipOrMaskError ++;
                continue;
            }
            //子网掩码全是0 非法
            if (maskString.lastIndexOf("1") == -1){
                ipOrMaskError ++;
                continue;
            }
            String tmpMask = maskString.substring(maskString.indexOf("1"),maskString.lastIndexOf("1"));
            //开始的1和结尾的1之间有0是非法掩码
            if(tmpMask.indexOf("0") != -1){
                ipOrMaskError += 1;
                continue;
            }
            //统计各类地址数量和私有地址数量
            if( ipPart1 >= 1 && ipPart1 <= 126 ){
                if(ipPart1 == 10){
                    privateIp ++;
                }
                ipA ++;
            }else if(ipPart1 >= 128 && ipPart1 <= 191 ){
                if(ipPart1 ==172&&ipPart2>=16&&ipPart2<=31){
                    privateIp++;
                }
                ipB ++;
            }else if(ipPart1 >= 192 && ipPart1 <= 223 ){
                if(ipPart1 ==192&&ipPart2==168){
                    privateIp++;
                }
                ipC ++;
            }else if(ipPart1 >= 224 && ipPart1 <= 239 ){
                ipD ++;
            }else if(ipPart1 >= 240 && ipPart1 <= 255 ){
                ipE ++;
            }
        }
        return ipA+" "+ipB+" "+ipC+" "+ipD+" "+ipE+" "+ipOrMaskError+" "+privateIp;
    }

    /*将掩码转二进制时，不足八位左边补0，按理说子网掩码应该是左边都是连续的1，右边都是连续的0，
    1和0同时存在，算法这种补0的方式主要是用于后边判断掩码是否合法，直接通过整数数字比较很麻烦*/
    private static String leftSide8(String str){
        String result="";
        if (str.length() < 8){
            for(int i=0;i<8-str.length();i++){
                result = "0"+str;
            }
        }else {
            result = str;
        }
        return result;
    }

}
