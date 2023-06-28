package lkhwtk.leetcode521;

/**
 * 思路痛Solution，这里没有用Math工具类，在空间复杂度上能好一点
 */
public class Solution1 {
    public int findLUSlength(String a, String b) {
        if(a.equals(b))
            return -1;
        return a.length() > b.length() ? a.length() : b.length();
    }
}
