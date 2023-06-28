package lkhwtk.leetcode387;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * 思路：将全部字符和出现的次数以键值对的方式存放到hashmap中，在遍历一遍字符串，找到第一个是1的字符的下标
 * 注意下leetcode692题也使用了getOrDefault这种方式，很巧妙
 */
public class Solution {
    public int firstUniqChar(String s) {
        //用HashMap替换Map进行初始化，能提升10ms左右时间
        HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
