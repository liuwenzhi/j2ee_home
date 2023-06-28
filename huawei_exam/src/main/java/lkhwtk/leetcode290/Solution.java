package lkhwtk.leetcode290;

import java.util.HashMap;

/**
 * 290. 单词规律
 * 本题采用和205题类似思路，注意本题中pattern的字符个数和s按照空格拆分后的数组长度可能不一致
 * 时空消耗都比较大
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> pattern2s = new HashMap<>();
        HashMap<String, Character> s2pattern = new HashMap<>();
        String[] temp = s.split("\\s+");
        int len = temp.length;
        //pattern的字符个数和s按照空格拆分后的数组长度不一致
        if(len!=pattern.length()){
            return false;
        }
        for (int i = 0; i < len; ++i) {
            char c = pattern.charAt(i);
            if (pattern2s.containsKey(c) && !temp[i].equals(pattern2s.get(c)) || (s2pattern.containsKey(temp[i]) && s2pattern.get(temp[i]) != c)) {
                return false;
            }
            pattern2s.put(c, temp[i]);
            s2pattern.put(temp[i], c);
        }
        return true;
    }
}

