package com.duomu.hj23;

import java.util.HashMap;
import java.util.Scanner;
/**
 * 通过优化HashMap对Main进行优化，提升10ms左右
 */
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            HashMap<Character,Integer> map = new HashMap<>();
            //记录出现最小次数数值
            int min = Integer.MAX_VALUE;
            String line = scanner.nextLine();
            //遍历字符串，提取字母出现次数
            for(int i=0;i<line.length();i++){
                if(!map.containsKey(line.charAt(i))){
                    map.put(line.charAt(i),1);
                }else{
                    map.put(line.charAt(i),map.get(line.charAt(i))+1);
                }
            }
            //获取出现次数最小值
            for(Integer v:map.values()){
                min = v<min?v:min;
            }
            //再次遍历字符串，输出出现次数不是最小值的那些字母
            for(int i=0;i<line.length();i++){
                if(map.get(line.charAt(i)) > min){
                    System.out.print(line.charAt(i));
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
