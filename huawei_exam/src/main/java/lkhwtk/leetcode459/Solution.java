package lkhwtk.leetcode459;

/**
 * 459. 重复的子字符串
 * 参考题解：简单明了！！关于java两行代码实现的思路来源
 * 注意思路中的分析：基于这个思想，可以每次移动k个字符，直到匹配移动 length - 1 次。
 * 如果length代表字符串的实际长度，移动到length-1长度的时候，代表不包含重复子串，
 * 移动的话，最多移动到一半。直接作为一个模板记一下吧，题解中证明的过程也貌似是整理出来的
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
