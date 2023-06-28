package lkhwtk.leetcode680;

/**
 * 680. 验证回文字符串 Ⅱ
 * 参考题解：官方题解，注意：本题技巧性极强，是贪心算法最合适的应用
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length()-1;
        while(low<high){
            if(s.charAt(low)==s.charAt(high)){
                low++;
                high--;
            }else{
                //到这里如果不是回文数，则删除low或者high指针指向的这个记录，删除这个元素之后再判断，不需要删除每一个元素单独判断，本题虽然是两层循环，实际时间复杂度O(n)
                return validPalindrome(s,low+1,high)||validPalindrome(s,low,high-1);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s,int low,int high) {
        //对于题目中给出的样例abca，进入循环的时候，验证的low和high的值相等，没进入循环返回true，一个元素算是回文数
        while(low<high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            }else{
                return false;
            }
        }
        return true;
    }
}
