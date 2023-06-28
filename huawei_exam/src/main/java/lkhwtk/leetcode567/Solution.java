package lkhwtk.leetcode567;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * 参考题解：官方，核心思路：字符整形数组配合滑动窗口+Arrays.equals进行数组排序
 * 本题用字节数组来模拟排列的字符组合，非常巧妙
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        //定义两个26位的字母数组，s1和s2只包括小写字母
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        //定义滑动窗口大小为s1的长度，统计出窗口内具体字符的个数，分别在cnt1和cnt2两个整形数组中进行累加
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        //如果第一轮窗口值就相等，直接返回true
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        //第二轮窗口遍历开始，窗口每次向右移动一位，s2第n位到第m-1位加入（第一轮窗口已经让第s2的n-1位加入），同时之前窗口的第一位出窗口
        //如果在窗口中出现cnt1和cnt2相等（cnt1已经固定，在cnt2上通过滑动窗口每次找到固定的几个值）
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        char[] c1 = {'a','b','c'};
        char[] c2 = {'c','b','a'};
        //通过Arrays.equals来判断数组是否相等
        System.out.println(Arrays.equals(c1,c2));
    }
}
