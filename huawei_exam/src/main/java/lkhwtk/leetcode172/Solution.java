package lkhwtk.leetcode172;

/**
 * 172. 阶乘后的零
 * 暴力求解很容易超过基本数据类型保存范围，需要使用技巧
 */
public class Solution {
    public int trailingZeroes(int n) {
        if(n==0){
            return 0;
        }
        Long temp = Long.valueOf(n+"");
        for(int i=n-1;i>0;i--){
            temp*=i;
        }
        String tmp = temp+"";
        int result = 0;
        for(int i=tmp.length()-1;i>=0;i--){
            if(tmp.charAt(i)=='0'){
                result++;
            }
        }
        return result;
    }
}
