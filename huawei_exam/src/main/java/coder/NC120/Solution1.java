package coder.NC120;

/**
 * 核心思路：逻辑右移，取最后一位查看，逻辑右移或者物理右移在计算负数的时候有问题
 */
public class Solution1 {
    public int NumberOf1(int n) {
        int num=0;
        while(n>0){
            num+=n&1;
            n = n >>> 1;
        }
        return num;
    }
}
