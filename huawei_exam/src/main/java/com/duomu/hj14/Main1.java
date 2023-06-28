package com.duomu.hj14;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 本题不能直接用TreeSet实现，排序之后还会去重。
 * 这里重写了比较方法，这个内容参考即可。效率不高
 */
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            Set<String> treeSet=new TreeSet<String>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int len = o1.length() > o2.length() ? o2.length() : o1.length();
                    char[] c1 = o1.toCharArray();
                    char[] c2 = o2.toCharArray();
                    for (int i = 0; i < len; i++) {
                        if (Integer.valueOf(c1[i]) > Integer.valueOf(c2[i])) {
                            return 1;
                        } else if (Integer.valueOf(c1[i]) < Integer.valueOf(c2[i])) {
                            return -1;
                        }
                    }
                    return c1.length == len ? -1 : 1;
                }
            });
            int n = scanner.nextInt();
            for(int i=0;i<n;i++){
                treeSet.add(scanner.next());
            }
            for(String item:treeSet){
                System.out.println(item);
            }
        }
        scanner.close();
    }
}
