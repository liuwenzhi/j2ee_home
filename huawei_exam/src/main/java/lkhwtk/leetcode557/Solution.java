package lkhwtk.leetcode557;

/**
 * 本题和牛客网12、13题有类似，可简单参考
 * 这种方法比较暴力，不推荐
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] temp = s.split("\\s+");
        for(int i=0;i<temp.length;i++){
            sb.append(reverse(temp[i])).append(" ");
        }
        return sb.toString().trim();
    }

    public String reverse(String str){
        return new StringBuffer(str).reverse().toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}
