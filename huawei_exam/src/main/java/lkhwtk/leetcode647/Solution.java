package lkhwtk.leetcode647;
/**
 * 647. 回文子串
 * 直接使用老的思路求解，参考leetcode5和hj32题，本题就是对这两道题的一个简化
 */
public class Solution {
    public int countSubstrings(String s) {
        //首先定义结果变量，为s的长度，s的每一个字符都可以作为一个回文数
        int result = s.length();
        int len = s.length();
        //如果字符串长度为1，则直接返回
        if(len==1){
            return result;
        }
        for(int i = 1; i < len; i++){
            //回文数是偶数情况
            int low = i-1;
            int high = i;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                //是回文数，就让result自增，其他啥也不用考虑
                result++;
            }
            //回文数是奇数情况
            low = i-1;
            high = i+1;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                //是回文数，就让result自增，其他啥也不用考虑
                result++;
            }
        }
        return result;
    }
}
