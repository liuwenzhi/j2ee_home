package lkhwtk.leetcode1071;

/**
 * 1071. 字符串的最大公因子
 * 参考题解：官方。本题题目稍微有点绕，注意str1和str2不确认谁大谁小，
 * 需要找到能同时满足str1和str2的最大公约数，然后注意：这个最大公约数，
 * 肯定是从第0位开始的，不可能在中间
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        // 从长度大的开始枚举
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (len1 % i == 0 && len2 % i == 0) {
                //本题最大的坑点在这里，X这个变量，肯定是从0开始的
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }

    /**
     * s大，t小，看t的长度具体和s差几倍，然后按照这个倍数拼接几次t，看看是否能等于s
     */
    public boolean check(String t, String s) {
        int lenx = s.length() / t.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= lenx; ++i) {
            ans.append(t);
        }
        return ans.toString().equals(s);
    }

    //个人验证包含思路，和官方的思路在时间上没有差别
    /*public boolean check(String t, String s) {
        if("".equals(s.replace(t, ""))){
            return true;
        }
        return false;
    }*/
}
