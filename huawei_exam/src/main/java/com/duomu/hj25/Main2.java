package com.duomu.hj25;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
//写的有点冗长，使用Treeset去重排序，ArrayList封装结果
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n1 = scanner.nextInt();
            String[] arr1 = new String[n1];
            for (int i = 0; i < n1; i++) {
                arr1[i] = scanner.next();
            }
            int n2 = scanner.nextInt();
            TreeSet<Integer> set=new TreeSet<>();
            for (int i = 0; i < n2; i++) {
                set.add(scanner.nextInt());
            }
            ArrayList<String> list=new ArrayList<>();
            int size=0;
            for (Integer integer : set) {
                String s=String.valueOf(integer);
                int count=0;
                boolean isContain=false;
                StringBuffer sBuffer=new StringBuffer();
                for (int i = 0; i < arr1.length; i++) {
                    if (arr1[i].contains(s)) {
                        count++;
                        sBuffer.append(i+" ");
                        sBuffer.append(arr1[i]+" ");
                        isContain=true;
                    }
                }
                if (isContain) {
                    String newString=sBuffer.toString();
                    list.add(s+" ");
                    list.add(count+" ");
                    list.add(newString);
                    size=size+count*2+2;
                }
            }
            System.out.print(size+" ");
            for (int i = 0; i <list.size(); i++) {
                if (i==list.size()-1) {
                    System.out.println(list.get(i).trim());
                }else {
                    System.out.print(list.get(i));
                }
            }
        }
    }
}
