package lkhwtk.leetcode821;

/**
 * 821. 字符的最短距离
 * 个人思路：遍历每一个字符的时候，都左右找一遍，效率偏低
 */
public class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            while(left>0&&s.charAt(left)!=c){
                left--;
            }
            while(right<s.length()-1&&s.charAt(right)!=c){
                right++;
            }
            int length = 0;
            if(s.charAt(left)==c){
                length = i-left;
            }else{
                //length就是做一个和右侧距离的比较
                length = s.length()+1;
            }
            if(s.charAt(right)==c){
                length = Math.min(length,right-i);
            }
            result[i] = length;
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.shortestToChar("loveleetcode",'e');
    }
}
