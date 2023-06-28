package lkhwtk.offer50;

import java.util.HashMap;
import java.util.Map;

/**
 * 比Solution1更好的一个处理方式
 * 采用boolean的方式，不用计算，效率相对于Solution1来说提升了一大截
 */
public class Solution1 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc) {
            //没出现过就是true，只要出现了就是false，真是巧妙的设计
            dic.put(c, !dic.containsKey(c));
        }
        for(char c : sc) {
            //找到第一个key对应value为true的，就是第一个只出现一次的
            if (dic.get(c)){
                return c;
            }
        }
        return ' ';
    }
}
