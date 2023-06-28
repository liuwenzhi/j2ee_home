package com.duomu.hj39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args)throws IOException {
        /**掩码地址数组*/
        int[] aaa = new int[4];
        /**待比较的两个入参ip地址数组*/
        int[] bbb = new int[4];
        int[] ccc = new int[4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            //a "255.255.255.0"
            String a=line;
            //b "192.168.224.256"
            String b=br.readLine();
            //c "192.168.10.4"
            String c=br.readLine();
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
