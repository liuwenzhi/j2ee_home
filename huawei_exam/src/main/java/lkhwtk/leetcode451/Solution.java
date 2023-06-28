package lkhwtk.leetcode451;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * 参考题解：官方
 * 核心思路：直接排序，把map放到List中，进行排序
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        //对map排序的方式，相当优秀的设计，将map保存到一个List列表中，对列表对象进行排序，这里必须要用Map的Entry对象
        List<Map.Entry<Character, Integer>> items = new ArrayList<>(count.entrySet());
        items.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder res = new StringBuilder();
        for(Map.Entry<Character, Integer> item : items){
            char key = item.getKey();
            int val = item.getValue();
            for(int i = 0; i < val; i++){
                //几个value就拼接几个key
                res.append(key);
            }
        }
        return res.toString();
    }
}
