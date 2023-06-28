package com.duomu.hj8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 优化输入之后，执行效率提升将近3倍
 */
public class Main1 {
    public static void main(String[] args)throws IOException {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            //记录总量
            int num = Integer.parseInt(line);
            for(int i=0;i<num;i++){
                String[] keyValues = br.readLine().split(" ");
                int key = Integer.parseInt(keyValues[0]);
                int value = Integer.parseInt(keyValues[1]);
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else{
                    map.put(key,value);
                }
            }
        }
        //Map.Entry<String, Integer> entry : tempMap.entrySet()
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
