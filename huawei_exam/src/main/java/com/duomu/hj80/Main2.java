package com.duomu.hj80;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 优化下Main方法的输入输出，用时达到最好
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            //数组1元素个数
            int num1 = Integer.parseInt(line);
            int[] array1 = new int[num1];
            //录入数组1中元素
            String[] temp1 = br.readLine().split(" ");
            for(int i=0;i<num1;i++){
                array1[i] = Integer.parseInt(temp1[i]);
            }
            //数组2元素个数
            int num2 = Integer.parseInt(br.readLine());
            int[] array2 = new int[num2];
            String[] temp2 = br.readLine().split(" ");
            for(int i=0;i<num2;i++){
                array2[i] = Integer.parseInt(temp2[i]);
            }
            System.out.println(mergeAndSort(array1,array2));
        }
    }

    private static String mergeAndSort(int array1[],int array2[]){
        //对数组1和数组2进行排序
        Arrays.sort(array1);
        Arrays.sort(array2);
        //采用归并方式合并数组1和数组2
        int[] temp = new int[array1.length+array2.length];
        //i控制array1归并位置，j控制array2归并位置，point是整体归并长度
        int i,j,point = 0;
        for(i=0,j=0;i<array1.length&&j<array2.length;){
            if(array1[i]<array2[j]){
                //array1元素比array2小，array1元素进临时数组
                temp[point++] = array1[i++];
            }else if(array1[i]>array2[j]){
                //array1元素比array2大，array2元素进临时数组
                temp[point++] = array2[j++];
            }else{
                //相等的情况进一个元素
                temp[point] = array1[i];
                point++;
                i++;
                j++;
            }
        }
        //比较完事之后，把array1和array2中可能的剩余元素放进临时数组
        while(i<array1.length){
            temp[point++] = array1[i++];
        }
        while(j<array2.length){
            temp[point++] = array2[j++];
        }
        //2021年9月4日三轮刷题增加去重优化：原始入参数组中，可能存在重复数据
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        stringBuilder.append(temp[0]);
        int before = temp[0];
        for(k=1;k<point;k++){
            if(temp[k]!=before){
                stringBuilder.append(temp[k]);
                before = temp[k];
            }
        }
        return stringBuilder.toString();
    }
}
