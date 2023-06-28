package lkhwtk.leetcode290;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 简单优化下Solution，用一个HashMap和一个HashSet来实现，这个验证后效果和Solution差不多，后边有需求再看看
 */
public class Solution1 {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] temp = s.split("\\s+");
        int len = temp.length;
        //pattern的字符个数和s按照空格拆分后的数组长度不一致
        if(len!=pattern.length()){
            return false;
        }
        for (int i = 0; i < len; ++i) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if(!temp[i].equals(map.get(c))){
                    return false;
                }
            }else{
                //map中不包含c的时候才存储，同时存放字符串到set集合中，如果map中不包含key，同时能在set中找到value，说明value和其它key已经对应了
                if(set.contains(temp[i])){
                    return false;
                }
                map.put(c, temp[i]);
                set.add(temp[i]);
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        solution.wordPattern("abba","dog cat cat dog");

    }

}
