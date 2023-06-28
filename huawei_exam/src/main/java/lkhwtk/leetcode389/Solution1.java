package lkhwtk.leetcode389;

/**
 * 解题技巧：抑或运算，本题可以转换成，将s和t整体看成一个字符串的话，一个字母出现了奇数次，其他都是出现偶数次，通过0
 * 和每一个字母进行抑或运算，可以找到这个出现奇数次的字母，证明过程很繁琐，记住结论即可。
 * 参考题解： 官方
 *          来看姨(1)句话找不同！reduce 搞起来 💪
 * 本题同136题，是136题算法的字符实现方案
 */
public class Solution1 {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c: s.toCharArray()) {
            res ^= c;
        }
        for (char c: t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}
