package lkhwtk.leetcode43;

/**
 * 43. 字符串相乘
 * 题解参考：优化版竖式(打败99.4%)
 * 普通竖式
 * addStrings方法的设计可以对比下hj78，这个方法可以作为字符串相加的标准模板
 */
public class Solution {
    /**
     * 计算形式
     *    num1
     *  x num2
     *  ------
     *  result
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            //乘法计算过程中的进位
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0，每一轮乘法，num2中的指定为和num1相乘，在后边相加的时候需要往前移动，这里有了补0的操作
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            //通过ascii码直接计算数值
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 的每一位相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        //carry是进位，这个不能拉下
        int carry = 0;
        //注意累加的条件，只有carry也要计算
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            //累加运算过程中，可能出现一个字符串长，一个字符串短的情况，这个时候补0处理
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            //字符串每次都是拼到后边，最终需要对结果进行反转
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.multiply("123","34");

    }

}
