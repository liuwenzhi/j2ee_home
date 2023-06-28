package lkhwtk.leetcode424;

/**
 * 424. 替换后的最长重复字符
 * 参考题解：通过此题了解一下什么是滑动窗口 Java 题解
 * 核心思路：滑动窗口，题解其实不太好理解，下边的讨论可以参考下
 */
public class Solution {
    /**map保存当前窗口中字母出现次数，不在窗口中会减掉*/
    private int[] map = new int[26];
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        //historyCharMax 保存 滑动窗口内 相同字母出现次数的 历史 最大值，切忌是历史最大值
        int historyCharMax = 0;
        for (; right < chars.length; right++) {
            int index = chars[right] - 'A';
            //窗口中元素自增
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            //判断窗口宽度是否等大于历史最大重复值+k，如果大了，则left++，left++之后，窗口的大小正好是historyCharMax + k，之后right++正好是滑动窗口
            //如果不大于，则right++,相当于窗口扩张
            if (right - left + 1 > historyCharMax + k) {
                //移动窗口之后，需要把左边界的元素个数-1，主要是historyCharMax保存的是滑动窗口内的 历史 最大值
                map[chars[left] - 'A']--;
                left++;
            }
        }
        //return right - left，right指针最后等于chars.length
        return chars.length - left;

    }
}
