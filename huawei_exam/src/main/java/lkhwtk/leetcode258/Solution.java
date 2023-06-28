package lkhwtk.leetcode258;

/**
 * 258. 各位相加
 * 头一次独立完成递归算法
 * 精选解法参考：【Java】O(1)解法的个人理解
 */
public class Solution {
    public int addDigits(int num) {
        int result = 0;
        while(num > 0){
            result+=num%10;
            num = num/10;
        }
        if(result < 10){
            return result;
        }else{
            return addDigits(result);
        }
    }
}
