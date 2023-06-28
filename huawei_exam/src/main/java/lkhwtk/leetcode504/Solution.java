package lkhwtk.leetcode504;

/**
 * 504. 七进制数
 * 参考题解：6ms 递归写法，适用于一切进制转换
 * 该算法采用的递归方式，适用于将十进制整数转成任意类型数字
 * 算法背一下
 */
public class Solution {
    private int n = 7;
    public String convertToBase7(int num) {
        //单独处理小于0的情况，拼一个负号，计算相反数
        if(num<0) {
            return "-" + convertToBase7(num * -1);
        }
        //单独处理0到7的情况，直接返回字符串
        if(num<n) {
            return num + "";
        }
        //商和余数即取模和求余
        return convertToBase7(num/n)+convertToBase7(num%n);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(24567));
    }
}
