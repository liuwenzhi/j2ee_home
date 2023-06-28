package lkhwtk.leetcode917;

/**
 * 官方思路2，想法上比本人的Solution好一些，时空性能上差不多
 */
public class Solution2 {
    public String reverseOnlyLetters(String s) {
        StringBuilder ans = new StringBuilder();
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetter(s.charAt(i))) {
                while (!Character.isLetter(s.charAt(j)))
                    j--;
                ans.append(s.charAt(j--));
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
