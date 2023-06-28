package lkhwtk.mst1607;

/**
 * 面试题 16.07. 最大数值
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * 参考题解：利用数学思维的方法
 * 直接用数学工作简单直接，注意
 */
public class Solution {
    public int maximum(int a, int b) {
        long c = a;
        long d = b;
        int res = (int) ((Math.abs(c-d) + c + d)/2);
        return res;
        //double效率能更高一点
        /*double c = a;
        double d = b;
        int res = (int) ((Math.abs(c-d) + c + d)/2);
        return res;*/
    }
}
