package lkhwtk.leetcode50;

/**
 * 直接用Math类计算幂
 */
public class Solution1 {
    public double myPow(double x, int n) {
        return Math.pow(x,n);
    }
    public static void main(String[] args){
        System.out.println(Math.pow(2,-3));
    }
}
