package com.duomu.hj3;

import java.util.*;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            Set<Integer> set = new HashSet<>();
            //获取每组的数据量
            int num = scanner.nextInt();
            int count = 0;
            while(count<num){
                set.add(scanner.nextInt());
                count++;
            }
            Integer a[] = new Integer[set.size()];
            int i = 0;
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()){
                a[i++] = iterator.next();
            }
            Arrays.sort(a);
            for(int j=0;j<a.length;j++){
                System.out.println(a[j]);
            }
        }
    }
}
