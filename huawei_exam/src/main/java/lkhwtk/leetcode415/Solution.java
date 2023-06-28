package lkhwtk.leetcode415;

/**
 *
 * 解题参考：字符串相加（官方）
 * 实现思路：模拟竖式加法
 * 本题是标准竖式模板
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1,j=num2.length()-1;
        int add = 0;
        StringBuilder result = new StringBuilder();
        //两个字符串都有余位，或者存在进位的时候进行循环
        while(i>=0||j>=0||add > 0){
            int val1 = i>=0?num1.charAt(i) - '0':0;
            int val2 = j>=0?num2.charAt(j) - '0':0;
            int temp = val1+val2+add;
            add = temp/10;
            result.append(temp%10);
            i--;j--;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.addStrings("86043","5582"));
    }
}
