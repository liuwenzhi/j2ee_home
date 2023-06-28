package com.duomu.hj45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    /*注意nextLine不要和next，nextInt等混着用，next和nextInt进行输入的时候后边跟回车的话，
    会被nextLine读成空字符串，所以类似本题的内容：开始输入整型使用nextLine然后转型的方式*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int num = Integer.parseInt(line);
            List<String> list = new ArrayList<>(num);
            for (int i = 0; i < num; i++) {
                list.add(br.readLine().toLowerCase());
            }
            count(list);
        }
    }
    private static void count(List<String> list){
        Map<Character,Integer> map = new HashMap<>();
        for(String name:list){
            for(int i=0;i<name.length();i++){
                if(!map.containsKey(name.charAt(i))){
                    map.put(name.charAt(i),1);
                }else{
                    map.put(name.charAt(i),map.get(name.charAt(i))+1);
                }
            }
            //获取数值
            int temp[] = new int[map.size()];
            int n = 0;
            for(Integer v:map.values()){
                temp[n++] = v;
            }
            //注意这个排序是从小到大的，因为原始map集合中可能会有重复元素，这里没有使用TreeSet进行排序
            Arrays.sort(temp);
            map.clear();
            int weight = 26,result = 0;
            for(int i=temp.length-1;i>=0;i--){
                result += temp[i]*weight;
                weight--;
            }
            System.out.println(result);
        }
    }
}
