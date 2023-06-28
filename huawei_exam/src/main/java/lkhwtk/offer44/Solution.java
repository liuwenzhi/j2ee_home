package lkhwtk.offer44;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 本题属于找规律的题目，背一下算法
 * 参考题解：官方题解
 * 参考题解：详解 找规律
 */
public class Solution {
    public int findNthDigit(int n) {
        //注意初始化：位数为整形，start和count是long型，问题在while循环中，入参n是在整数范围内，start和count有可能都大于n，
        //出while的条件是n<=count，此时start和count都可能大于了n，超过实际整形表示范围
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        //使用Long.toString这种方式将num转为字符串效率很高，比num+""要高很多
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
