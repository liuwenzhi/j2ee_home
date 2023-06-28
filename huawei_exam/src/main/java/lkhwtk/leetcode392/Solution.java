package lkhwtk.leetcode392;

/**
 * 392. 判断子序列
 * 官方双指针思路，想法太好了
 * 注意：子序列可以不连续，但是会保留字符顺序，比如s = "abc", t = "ahbgdc"，这个可以，s = "cba", t = "ahbgdc"这个就不行
 * 虽然t包含了s中全部字符，但是不是按照s的顺序
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        //点睛之笔，判断最后s中能匹配上的字符是否等于s字符串的长度，每次匹配上一次，i自增一次，1个字母匹配为1,2个字母匹配为2。
        return i == n;
    }

}
