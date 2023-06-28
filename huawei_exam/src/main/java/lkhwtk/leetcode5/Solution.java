package lkhwtk.leetcode5;

/**
 * 5. 最长回文子串
 * 本题的核心思路为中心扩散法，从中心往两边扩散，本题和hj32题很类似，需要考虑一些边界情况
 * 一定要注意左右或者上下边界，还有扩散边界的值要相等，具体参考21行和37行代码
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 1;
        int start = 0,end = 0;
        //如果字符串长度为1，则直接返回
        if(len==1||(len==2&&s.charAt(0)!=s.charAt(1))){
            return s.substring(0,1);
        }
        for(int i = 1; i < len; i++){
            //回文数是偶数情况，每次循环都是相邻两个
            int low = i-1;
            int high = i;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
            }
             /*注意：这里为啥是high-low-1，因为此刻上边while循环结束之后，low比实际回文数最小下标小1，high大1，
            实际回文数下标位置是 low+1到high-1，然后从low+1到high-1这两个下标之间，一共有数字（high-1）—（low+1）+1，这个值是high-low-1
            */
            if(high-low-1 > max){
                max = high-low-1;
                start = low;
                end = high;
            }

            //回文数是奇数情况，每次循环都是遍历隔一个的两个元素
            low = i-1;
            high = i+1;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
            }
            if(high-low-1 > max){
                max = high-low-1;
                start = low;
                end = high;
            }
        }
        //注意：这里可能存在start和end都没走的情况，start和end都是0，按照题目要求，返回第一个字母即可，条件也可以写成start < end或者start!=end，总之就是start和end发生了移动
        //在21行和37行的循环中，如果满足条件拿到最大值和最小值之后，start和end都分别向左右多走了一步
        if(start+1<end-1){
            //注意实际字符串下标是start+1到end-1，因为substring具有前包含后不包含的特点，这边这么来写
            return s.substring(start+1,end);
        }
        //如果start和end都没有发生移动，则直接返回第一个字母
        return s.substring(0,1);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("bb"));
        System.out.println(solution.longestPalindrome("abcda"));
    }
}
