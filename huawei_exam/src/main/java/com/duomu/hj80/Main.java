package com.duomu.hj80;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 题目标题：
 *
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 * 请注意本题有多组样例。
 *
 *
 *
 * 输入描述:
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 *
 * 输出描述:
 * 输出合并之后的数组
 *
 * 示例1
 * 输入
 * 复制
 * 3
 * 1 2 5
 * 4
 * -1 0 3 2
 * 输出
 * 复制
 * -101235
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //数组1元素个数
            int num1 = scanner.nextInt();
            int[] array1 = new int[num1];
            //录入数组1中元素
            for(int i=0;i<num1;i++){
                array1[i] = scanner.nextInt();
            }
            //数组2元素个数
            int num2 = scanner.nextInt();
            int[] array2 = new int[num2];
            for(int i=0;i<num2;i++){
                array2[i] = scanner.nextInt();
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