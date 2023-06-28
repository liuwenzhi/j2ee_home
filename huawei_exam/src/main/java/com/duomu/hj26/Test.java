package com.duomu.hj26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 本题必须要重写Collections的比较器，坑点在于排序不区分大小写字母，不重写比较器，直接
 * 按照Collections.sort的方式，会按照字典进行排序，这个排序和Main中的排序效率差不多
 */
public class Test {
    public static void main(String[] args){
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('A');
        list.add('B');
        Collections.sort(list,new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        for(char c:list){
            System.out.println(c);
        }
    }
}
