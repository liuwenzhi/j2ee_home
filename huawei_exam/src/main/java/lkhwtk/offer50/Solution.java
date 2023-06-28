package lkhwtk.offer50;

import java.util.HashMap;
import java.util.Map;

/**
 * 借助hashmap来实现
 */
public class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc){
            dic.put(c, dic.getOrDefault(c,0)+1);
        }
        for(char c : sc){
            if(dic.get(c)==1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args){
        Solution solution1 = new Solution();
        solution1.firstUniqChar("leetcode");
    }

}
