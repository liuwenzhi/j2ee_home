package com.duomu;

public class Test {
    public static void main(String[] args){
        int[] a = {7,1,5,3,6,4};
        int max = 0;
        //穷举法
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                int cache = a[j]-a[i];
                if(cache>max){
                    max = cache;
                }
            }
        }
        System.out.println(max);
    }
}
