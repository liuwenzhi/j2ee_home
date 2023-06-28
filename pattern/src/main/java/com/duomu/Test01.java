package com.duomu;

import java.util.ArrayList;
import java.util.List;

class Swan {
    public static void fly(){
        System.out.println("swan can fly...");
    }
}

class UglyDuck extends Swan{
    public static void fly(){
        System.out.println("ugly duck can't fly...");
    }
}
public class Test01 {
    public static void main(String[] args){
        /*List arrayList = new ArrayList();
        arrayList.add("aaaaa");
        arrayList.add(100);
        System.out.println(arrayList.get(0));
        System.out.println((String)arrayList.get(1));
        Integer i = new Integer(3);
        System.out.println(i+"");*/
        //String s = (String)i;
        /*List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List list3 = new ArrayList();
        System.out.println(list1.getClass().equals(list2.getClass()));
        System.out.println(list1.getClass().equals(list3.getClass()));
        System.out.println(list2.getClass().equals(list3.getClass()));*/
        Swan swan = new Swan();
        UglyDuck uglyDuck = new UglyDuck();
        swan.fly();
        uglyDuck.fly();
    }
}
