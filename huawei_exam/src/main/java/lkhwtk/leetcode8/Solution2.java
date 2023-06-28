package lkhwtk.leetcode8;

/**
 * 基于Solution1的有点对Solution进行改进
 * 改进后得到结果：Character.isDigit(s.charAt(i))不会影响整体的耗时时间，
 * 主要是Integer.parseInt(s.charAt(i)+"")耗时比较长，Solution2的耗时时间已经和Solution不相上下了。
 */
public class Solution2 {
    public int myAtoi(String s) {
        //数字正负标志，+ true，- false
        boolean flag = true;
        //最终数字
        int num = 0;
        //去掉前导空格
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        //空字符串的情况，直接返回0
        if (index == s.length()) {
            return 0;
        }
        //去掉前导空格之后再判断正负
        if (s.charAt(index) == '-') {
            flag = false;
            index++;
        } else if (s.charAt(index) == '+') {
            //去掉空格之后，可能会有正号，可能没有，还是要判断一下
            index++;
        }
        for (int i = index; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (flag && (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && (s.charAt(i) -'0') > Integer.MAX_VALUE % 10)) {
                    num = Integer.MAX_VALUE;
                    break;
                } else if (!flag && num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && (s.charAt(i) -'0') >= 8) {
                    //这里已经标记为最负的一个数字，flag就不用再进行为负判断了,另外这里加了一步等于8，因为不能通过正数计算之后再转负数了
                    num = Integer.MIN_VALUE;
                    flag = true;
                    break;
                }
                num = num * 10 + (s.charAt(i) -'0');
                continue;
            }
            //如果读到字母或者其他符号就退出
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
        }
        if (!flag) {
            return num * (-1);
        } else {
            return num;
        }
    }
}
