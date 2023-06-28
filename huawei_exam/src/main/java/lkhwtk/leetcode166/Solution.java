package lkhwtk.leetcode166;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 参考题解：官方。
 * 本题主要是细节和边界
 * 算法主要是基于商和被除数的对应位，除法中余数的计算，从这两点中找到规律。
 * 算法是提取了得到具体的余数，对应的上商的长度，然后确认当结果出现循环小数的时候，在对应的商的位置上插入左括号，然后在字符串末尾插入右括号。
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        //抑或预算，相同为0，不同为1，这里是判断被除数和除数是否同号，不同号的情况下需要拼一个负号
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        //将数字转成Long型，否则计算abs(-2147483648)会出现溢出
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        //结果先拼上商，此时不包含小数位
        fraction.append(String.valueOf(dividend / divisor));
        //取余数，如果余数为0，直接返回，说明没有小数位
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        //存在余数的情况下，拼接小数位
        fraction.append(".");
        //map记录余数信息，key是余数，value是当前结果长度，在存在循环的情况下，能够确认插入左括号 ( 的位置
        Map<Long, Integer> map = new HashMap<>();
        //核心代码：插入括号的位置是通过观察计算得到的，注意这个地方
        while (remainder != 0) {
            //小数位存在循环的情况
            if (map.containsKey(remainder)) {
                //在余数循环的位置插入左括号，以1/6为例，0.16... 6开始循环，那么就在第一个6的位置插入一个(，字符串最后再拼一个)，拼好了之后直接跳出循环
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            //map存放余数，当余数出现循环的时候，对应的商也会循环。
            map.put(remainder, fraction.length());
            //余数*10，再和除数做除法，得到新的余数，实际上在模拟除法运算，找小数位，需要判断你是否存在循环
            remainder *= 10;
            //结果字符串拼接下余数做除法的商
            fraction.append(String.valueOf(remainder / divisor));
            //得到商之后再获取余数
            remainder %= divisor;
        }
        return fraction.toString();
    }

}
