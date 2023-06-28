package lkhwtk.leetcode67;

/**
 * 参考43题 中字符串相加的内容
 * 参考415题 十进制相加，竖式加法模板
 */
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for(int i = a.length()-1,j=b.length()-1;i>=0||j>=0||carry>0;i--,j--){
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = (x+y+carry)%2;
            builder.append(sum);
            carry = (x+y+carry)/2;
        }
        return builder.reverse().toString();
    }

}
