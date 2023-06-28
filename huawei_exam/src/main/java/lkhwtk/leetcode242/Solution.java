package lkhwtk.leetcode242;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 */
public class Solution {

    /**
     * 取出字符数组，排序后判断是否相同
     */
    private boolean isBrother(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public boolean isAnagram(String s, String t) {
        //只有在两个字符串长度相等的情况下可能是异位单词
        if(s.length()==t.length()){
            return isBrother(s,t);
        }
        return false;

    }
}
