package coder.NC17;

/**
 * 基于个人标准回文数模板梳理
 * 本题同leetcode5，hj32，稍微简答一点，给出最大长度即可
 */
public class Solution1 {
    public int getLongestPalindrome(String A, int n) {
        //最大长度变量，单独一个字母的情况
        int max = 1;
        int start = 0,end = 0;
        //如果字符串长度为1，或者长度为2，但是两个字符不相等，则直接返回
        if(n==1||(n==2&&A.charAt(0)!=A.charAt(1))){
            return max;
        }
        for(int i = 1; i < n; i++){
            //回文数是偶数情况，每次循环都是相邻两个
            int low = i-1;
            int high = i;
            while(low >= 0 && high < n && A.charAt(low) == A.charAt(high)){
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
            while(low >= 0 && high < n && A.charAt(low) == A.charAt(high)){
                low--;
                high++;
            }
            if(high-low-1 > max){
                max = high-low-1;
                start = low;
                end = high;
            }
        }
        return max;
    }

}
