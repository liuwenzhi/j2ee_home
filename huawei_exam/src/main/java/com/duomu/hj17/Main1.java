package com.duomu.hj17;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * main1的效率比main高一些，效果更好
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            int x = 0 , y = 0;
            String[] sArray = s.split(";");
            //根据正则表达式进行匹配，然后把ADWS分配以A、D、W、S作为key存放到map中，对应的值进行累加，最后左右上下进行各自统计
            String res = "[ADWS]\\d{1}\\d?";
            for(int i = 0;i < sArray.length;i ++) {
                if(sArray[i].matches(res)){
                    //ADWS各自value值累加统计，这里getOrDefault用的很巧，没有这个key的之后就按照0来进行统计
                    map.put(sArray[i].charAt(0),map.getOrDefault(sArray[i].charAt(0), 0)+Integer.valueOf(sArray[i].substring(1)));
                }
            }
            x = x - map.get('A') + map.get('D');
            y = y - map.get('S') + map.get('W');
            System.out.println(x+","+y);
            map.clear();
        }
        scanner.close();
    }
}
