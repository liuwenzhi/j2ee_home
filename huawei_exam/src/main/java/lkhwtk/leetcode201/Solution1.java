package lkhwtk.leetcode201;

/**
 * 参考题解：数字范围按位与 官方
 * 与运算的性质：对所有数字执行按位与运算的结果是所有对应二进制字符串的公共前缀再用零补上后面的剩余位。
 * 进一步来说，所有这些二进制字符串的公共前缀也即指定范围的起始和结束数字 left 和 right 的公共前缀
 * 这个性质自己拿数字算一下就懂了
 */
public class Solution1 {
    /**
     * 思路：位移，先右移数字，找到公共前缀，记录移动次数，
     * 再左移同样的次数，这样的话，进行与运算的过程中，不
     * 需要一个一个数字的计算一遍，只需要对头和尾两个数字进行计算即可
     */
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left!=right){
            left = left >> 1;
            right = right >> 1;
            shift++;
        }
        return left << shift;
    }
}
