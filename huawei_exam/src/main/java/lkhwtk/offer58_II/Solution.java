package lkhwtk.offer58_II;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 个人思路
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(n));
        for(int i=0;i<n;i++){
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] agrs){
        String s = "0123456";
        System.out.println(s.substring(0));
        System.out.println(s.substring(0,s.length()));
    }
}
