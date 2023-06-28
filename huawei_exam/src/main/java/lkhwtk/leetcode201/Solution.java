package lkhwtk.leetcode201;

/**
 * 201. 数字范围按位与
 * 直接计算会导致超时，本题一共8400+用例，直接计算正着计算只能通过两个用例
 * 如果是倒着计算，是数值越来越小，能通过99.8%的测试用例，还有几个会超时
 */
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int value = right;
        for(int i=right-1;i>=left;i--){
            value = value&i;
        }
        return value;
    }

    //根据Solution2优化的算法
    /*public int rangeBitwiseAnd(int left, int right) {
        int i;
        for(i=right;i>left;){
            i = i&(i-1);
        }
        return i;
    }*/

    public static void main(String[] args){
        System.out.println(4&5);
    }
}
