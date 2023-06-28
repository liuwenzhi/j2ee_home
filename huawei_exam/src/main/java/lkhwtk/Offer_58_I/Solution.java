package lkhwtk.Offer_58_I;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 思路参考：华为机试13题
 */
public class Solution {
    public String reverseWords(String s) {
        String s1[] = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=s1.length-1;i>=0;i--){
            stringBuilder.append(s1[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
