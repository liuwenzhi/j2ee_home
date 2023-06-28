package com.duomu.hj80;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 80题是09年培训就遇到的老朋友了，印象非常深刻，计算机专业课全国统考的时候考过这道题。
 * 有点投机取巧的方法
 * 元素直接放到set集合里边去重，然后再放到整型数组里边进行排序即可。
 *  * 输入
 *  * 复制
 *  * 3
 *  * 1 2 5
 *  * 4
 *  * -1 0 3 2
 *  * 输出
 *  * 复制
 *  * -101235
 */
public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Set<Integer> set = new HashSet<>();
            int n1 = in.nextInt();
            for (int i = 0; i < n1; i++){
                set.add(in.nextInt());
            }
            int n2 = in.nextInt();
            for (int i = 0; i < n2; i++){
                set.add(in.nextInt());
            }
            int n3 = set.size();
            int[] arr = new int[n3];
            int k = 0;
            for (int i : set){
                arr[k] = i;
                k++;
            }
            Arrays.sort(arr);
            String res = "";
            for (int i = 0; i < n3; i++){
                res += arr[i];
            }
            System.out.println(res);
        }
    }
}
