package lkhwtk.leetcode58;

/**
 * 58. 最后一个单词的长度
 * 牛客网华为机试第一题，注意这里需要单独处理下边界，输入可能有" "这种用例
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String temp[] = s.split(" ");
        int length = temp.length;
        if(temp.length == 0){
            return 0;
        }
        return temp[length-1].length();
    }

    public static void main(String[] args){
        String s = " ";
        String temp[] = s.split(" ");
        System.out.println(temp.length);
    }
}
