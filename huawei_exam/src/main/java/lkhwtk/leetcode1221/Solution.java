package lkhwtk.leetcode1221;

/**
 * 1221. 分割平衡字符串
 * 核心思路：不用往复杂了想，建立一个整形的平衡系数，遍历字符串，如果字符是L，平衡系数自增，
 * 如果字符是R，平衡系数自减，在经历过自增和自减操作之后，如果平衡系数为0，这说明达到LR平衡
 */
public class Solution {
    public int balancedStringSplit(String s) {
        //平衡系数
        int balance = 0;
        //最终返回结果
        int result = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='L'){
                balance++;
            }else{
                balance--;
            }
            if(balance==0){
                result++;
            }
        }
        return result;
    }
}
