package lkhwtk.leetcode70;

/**
 * 题解参考：爬楼梯 官方
 * 本题看似麻烦，实际为斐波那契数列的变形
 * 本题和518题可以一起看下
 */
public class Solution {

    /**
     * 思路1：递归，本题使用递归会导致超时
     */
    public int climbStairs(int n) {
        if(n==0){
            return 1;
        }else if(n==1){
            return 1;
        }else{
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(5));
    }

}
