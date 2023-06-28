package com.duomu.hj94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//HashMap是无序的（只是说不是你插入时的顺序）；
//LinkedHashMap是有序的（按你插入的顺序）；
//TreeMap 是按key排序的；
//之前用hashmap不行，换成Linkedhaspmap
public class Main1{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            //候选人数
            int candidateNum = Integer.parseInt(line);
            //map里边存放候选人票数信息，外加一个不合法票数
            LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
            String[] candidateInfo = br.readLine().split(" ");
            for(int i=0;i<candidateNum;i++){
                map.put(candidateInfo[i],0);
            }
            map.put("Invalid",0);
            //投票人数
            int voter = Integer.parseInt(br.readLine());
            String[] votes = br.readLine().split(" ");
            for(String vote:votes){
                if(map.containsKey(vote)){
                    int value = map.get(vote);
                    map.put(vote,++value);
                }else{
                    int value = map.get("Invalid");
                    map.put("Invalid",++value);
                }
            }
            //通过Entry遍历map集合
            for(Map.Entry entry:map.entrySet()){
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            //通过keySet遍历map集合
            /*for(String key : map.keySet()){
                System.out.println(key + " : " + map.get(key));
            }*/
        }
    }

}
