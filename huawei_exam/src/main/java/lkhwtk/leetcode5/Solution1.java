package lkhwtk.leetcode5;

/**
 * 按照647题中心扩展法实现最长回文字符串查找
 */
public class Solution1 {
    /*中心扩展思路*/
    public String longestPalindrome(String s) {
        //最终结果
        String result = "";
        /*定义中心点的个数，为s.length()*2-1，回文数可能是奇数个字母，也可能是偶数个字母，中心点包括1个点，也可能是两个点
        比如abccab，可以进行扩计算的中心点包括a,b,c,c,a,b,ab.bc.cc,ca,ab，一个点的中心点树为s.length()，两个点的中心点树为s.length()-1*/
        int centerPointLength = 2*s.length()-1;
        for(int i=0;i<centerPointLength;i++){
            int left = i/2;
            int right = left + i%2;
            while(left>=0&&right<s.length()&&(s.charAt(left)==s.charAt(right))){
                //注意前包含后不包含，right要加1，
                String tmp = s.substring(left, right + 1);
                if (tmp.length() > result.length()) {
                    result = tmp;
                }
                //上边取值判断逻辑之后，left和right才能继续向两边扩展
                left--;
                right++;
            }
        }
        return result;
    }
}
