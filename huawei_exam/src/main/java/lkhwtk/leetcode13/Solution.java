package lkhwtk.leetcode13;

/**
 * 13. 罗马数字转整数
 * 参考题解：用时 99.93%，内存98.73%，简单解法
 * 本题直接记一下这个思路
 */
public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            //根据罗马计数规则，如果后一个字母比前一个字母大，则累加和减掉前一个字母，否则累加和加上前一个字母
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        //最后再补加一下最后边这个字母
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
