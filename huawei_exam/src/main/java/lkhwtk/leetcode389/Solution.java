package lkhwtk.leetcode389;

/**
 * 389. 找不同
 * 个人思路：基于整形数组，整体时间效率偏低
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] letter = new int[26];
        for(int i=0;i<s.length();i++){
            letter[s.charAt(i)-97]++;
        }
        for(int i=0;i<t.length();i++){
            if(letter[t.charAt(i)-97]==0){
                return t.charAt(i);
            }else{
                //匹配一次，减一次，这样出现main函数中重复的字母，就能够在if中找到不同的字母
                letter[t.charAt(i)-97]--;
            }
        }
        return ' ';
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.findTheDifference("a","aa");
    }
}
