package lkhwtk.offer48;

import java.util.HashMap;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 本题核心思路：滑动窗口，题目同leetcode3
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        //Map的key存放s中的每一个字符，value存放具体key的位置下标
        HashMap<Character, Integer> map = new HashMap<>();
        //max记录最大窗口长度
        int max = 0;
        //left记录窗口左侧边界，右侧边界是for循环中的i
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            //如果map中包含了i这个字符，left走到之前i字符位置的后一个位置，或者如果left本身比那个位置靠后，就不管，left的移动是窗口左侧边界
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            //循环之后更新map，同时每一次循环之后重新计算窗口大小
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
