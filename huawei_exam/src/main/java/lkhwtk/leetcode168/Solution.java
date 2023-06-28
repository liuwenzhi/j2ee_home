package lkhwtk.leetcode168;

/**
 * 168. Excel表列名称，本题是一个偏向于数学计算的问题，可以提炼成把一个十进制数字转成26进制数字
 * 参考题解：官方，【宫水三叶】从 1 开始的 26 进制转换题，记下思路吧，算法求证过程见官方题解
 * 本题和171题类似
 */
public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
