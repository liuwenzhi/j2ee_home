package com.duomu.hj67;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 核心思路：递归+回溯
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        double result=0.0;
        int[] num=new int[4];
        while((line=br.readLine())!=null){
            String[] cache = line.split(" ");
            int[] temp=new int[4];
            for(int i=0;i<4;i++){
                num[i]=Integer.parseInt(cache[i]);
            }
            System.out.println(check(num,temp,result));
        }
    }

    /**
     * 递归检查方法，实际就是遍历出所有数字所有字符的全部组合，只要能搞出24就返回true
     * 很漂亮取巧的算法
     */
    private static boolean check(int[] num,int[] temp,double result) {
        for(int i=0;i<num.length;i++){
            if(temp[i]==0){
                //temp[i]用于标记第i个数字在一次公式计算过程中，是否使用了，在没有被使用的情况下才能用，这里实际是递归+回溯的思路
                temp[i]=1;
                if(check(num,temp,result+num[i])
                        || check(num,temp,result-num[i])
                        || check(num,temp,result*num[i])
                        || check(num,temp,result/num[i])){
                    return true;
                }
                temp[i]=0;
            }
        }
        //以6 6 6 6为例，当for循环遍历到最后一个6的时候，也走了一个递归循环，此时temp[0]~temp[3]4个元素都被使用了
        //那么就来判断下result是否等于24，是就返回true，递归方法的实际出口是在这里，没有放到上边，应该是为了避免
        //出现不满4个数的组合达到了24的情况
        if(result==24){
            return true;
        }else{
            return false;
        }
    }

}
