package lkhwtk.leetcode387;

/**
 * 注意本题提示信息：你可以假定该字符串只包含小写字母。
 * 用数组替换Map，能提升很大效率
 */
public class Solution1 {
    public int firstUniqChar(String s) {
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            temp[ch-'a']++;
        }
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (temp[ch-'a']==1) {
                return i;
            }
        }
        return -1;
    }
}
