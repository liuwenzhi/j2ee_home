package lkhwtk.leetcode125;

/**
 * 125. 验证回文串
 * 双指针优化，代码简化了，但是存储效率低了
 */
public class Solution1 {
    public boolean isPalindrome(String s) {
        if ("".equals(s.trim())) {
            return true;
        }
        //i前指针，j是后指针
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char before = s.charAt(i);
            char end = s.charAt(j);
            //如果i指向元素不是字母也不是数字
            if (!Character.isLetterOrDigit(before)) {
                i++;
                continue;
            }
            //如果j指向元素不是字母也不是数字
            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(before)==Character.toLowerCase(end)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
