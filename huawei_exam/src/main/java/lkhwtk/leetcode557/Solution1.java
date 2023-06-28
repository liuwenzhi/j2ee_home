package lkhwtk.leetcode557;

/**
 * 一种优化解法：以空格分隔，每次从后往前统计
 */
public class Solution1 {
    public String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            //步骤1：字母统计
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            //步骤2：反向拼接字母
            for (int p = start; p < i; p++) {
                //从后往前拼字母start到i-1
                ret.append(s.charAt(start + i - 1 - p));
            }
            //步骤3：空格统计，然后再拼接空格
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
