package lkhwtk.leetcode434;

/**
 * 这种实现效率比Solution高，按照空格拆分之后，再判断下是不是空字符串就行了
 */
public class Solution1 {
    public int countSegments(String s) {
        int ans = 0;
        String[] arr = s.split(" ");
        for (String a : arr) {
            if (!a.equals("")) {
                ans++;
            }
        }
        return ans;
    }
}
