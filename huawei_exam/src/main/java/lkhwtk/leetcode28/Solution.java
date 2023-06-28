package lkhwtk.leetcode28;

/**
 * 28. 实现 strStr()
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        for(int i=0;i<=l1-l2;i++){
            if(haystack.substring(i,i+l2).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String s = "abc";
        System.out.println("".length());
        System.out.println(s.substring(0,"".length()));
        System.out.println(s.substring(0,"".length()).equals(""));
    }
}
