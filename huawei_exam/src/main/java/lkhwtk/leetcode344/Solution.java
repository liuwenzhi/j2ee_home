package lkhwtk.leetcode344;

/**
 * 反转字符串，使用O(1)的空间复杂度反转一个字符数组
 *
 * 注意：本题不需要区分数组的长度是奇数和偶数
 * 奇数如：0 1 2 3 4，按照题目中算法2不会动
 * 偶数如：0 1 2 3 4 5，按照题目中算法2和3会互换
 */
public class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        for(int i=0;i<length/2;i++){
            char temp = s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = temp;
        }
    }
}
