package lkhwtk.leetcode186;

/**
 * 186. 翻转字符串里的单词 II
 * 参考题解：java 两次翻转
 * 单独写一个从哪一位到哪一位的翻转函数，先全局翻转一次，再每个字母单独翻转一次，不要落下最后一个字母
 */
public class Solution1 {
    /**
     * 翻转字符数组从start位到end位的方法
     */
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    public void reverseWords(char[] s) {
        // 两次翻转即可，第一次全局翻转，第二次翻转各个单词
        int len = s.length;
        reverse(s, 0, len - 1);

        int start = 0;
        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                // 翻转前面的单词
                reverse(s, start, i-1);
                //i是空格字符，之后start从i+1开始
                start = i + 1;
            }
        }

        // 翻转最后一个单词
        reverse(s, start, len - 1);
    }
}
