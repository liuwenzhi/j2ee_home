package lkhwtk.leetcode186;

/**
 * 186. 翻转字符串里的单词 II
 * 个人思路，效率很低
 */
public class Solution {
    public void reverseWords(char[] s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length;i++){
            stringBuilder.append(s[i]);
        }
        String[] temp = stringBuilder.toString().split(" ");
        int index = 0;
        for(int i=temp.length-1;i>=0;i--){
            for(int j=0;j<temp[i].length();j++){
                s[index++] = temp[i].charAt(j);
            }
            if(i!=0){
                s[index++] = ' ';
            }
        }
    }

    public static void main(String[] args){
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        Solution solution = new Solution();
        solution.reverseWords(s);
    }
}
