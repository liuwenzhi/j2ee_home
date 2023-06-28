package lkhwtk.leetcode9;

/**
 * 9. 回文数
 * 思路：将该数字反转，看看两个值是否相等。注意：本题不是求解回文序列或者回文子串，直接判断一个数字是不是回文数，直接反转判断就行了
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            //负数一定不是回文数
            return false;
        }
        int temp = 0;
        int cache = x;
        while(cache > 0){
            temp = temp*10+cache%10;
            cache = cache/10;
        }
        return x == temp;
    }
}
