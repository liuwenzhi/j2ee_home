package com.duomu.hj88;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            String[] arr = line.split("-");
            System.out.println(helper(arr[0], arr[1]));
        }
    }
    private static String helper(String s1, String s2){
        //注意A，2，王的比较方式
        HashMap<String, Integer> map = new HashMap<String, Integer>(){
            {
                put("A", 14);
                put("2", 15);
                put("3", 3);
                put("4", 4);
                put("5", 5);
                put("6", 6);
                put("7", 7);
                put("8", 8);
                put("9", 9);
                put("10", 10);
                put("J", 11);
                put("Q", 12);
                put("K", 13);
                put("joker", 16);
                put("JOKER", 17);
            }
        };
        //对王最大
        if (s1.equals("joker JOKER") || s1.equals("JOKER joker")){
            return s1;
        }else if (s2.equals("joker JOKER") || s2.equals("JOKER joker")){
            return s2;
        }
        String[] arr1 = s1.split(" ");
        int n1 = map.get(arr1[0]);
        String[] arr2 = s2.split(" ");
        int n2 = map.get(arr2[0]);
        if (isBoom(s2) && isBoom(s1)){
            //都是炸弹比较牌面大小
            return n1 > n2 ? s1 : s2;
        }else if (isBoom(s2)) {
            //s2是炸弹s2大
            return s2;
        }else if (isBoom(s1)) {
            //s1是炸弹s1大
            return s1;
        }else if (arr1.length == arr2.length){
            //其他两手牌长度相等的情况，第一张牌大的大
            return n1 > n2 ? s1 : s2;
        }else{
            //再其他为比较不了的情况
            return "ERROR";
        }
    }

    /**
     * 判断是否是炸弹
     */
    private static boolean isBoom(String s1){
        String[] temp = s1.split(" ");
        if (temp.length != 4) return false;
        String cur = temp[0];
        for (int i = 1; i < 4; i++){
            if (!cur.equals(temp[i])) return false;
        }
        return true;
    }
}
