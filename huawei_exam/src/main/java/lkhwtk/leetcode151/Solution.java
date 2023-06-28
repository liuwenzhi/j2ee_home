package lkhwtk.leetcode151;

/**
 * 151. 翻转字符串里的单词
 * 参考华为机试13题
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp[] = s.split("\\s+");
        for(int i=temp.length-1;i>=0;i--){
            stringBuilder.append(temp[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
