package lkhwtk.leetcode29;

/**
 * 29. 两数相除
 * 参考思路：速看，简单易懂，时间100%,空间99%+ 两个while 思路清晰
 * 背一下思路
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        //处理一种极端情况，如果被除数是最小值，除数是-1，此时返回整形最大值，实际已经越界（基于提示第三点）
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        //用long型保存被除数和除数
        long divid = dividend;
        long divis = divisor;
        //在计算除法过程中，涉及到数据位移，带符号移动会影响计算结果，计算过程中将被除数和除数都弄成正数，flag标记最后是否需要将结果变换符号（被除数和除数之间正负不一致）
        boolean flag = true;
        long temp, result = 1, ans = 0;
        //根据除数和被除数符号设置flag，同时将除数和被除数都转为整数
        if(divid < 0 && divis > 0){
            divid = - divid;
            flag = false;
        }else if(divid > 0 && divis < 0){
            divis = - divis;
            flag = false;
        }else if(divid < 0 && divis < 0){
            divid = - divid;
            divis = - divis;
        }
        //核心设计：使用两层while循环计算结果
        while(divid - divis >= 0){
            temp = divis << 1;
            result = 1;
            while(divid - temp >= 0){
                result = result << 1;
                temp = temp << 1;
            }
            divid -= temp >> 1;
            ans += result;
        }

        if(flag){
            return (int)ans;
        }else{
            return (int)-ans;
        }
    }
    public static void main(String[] args){
        //3
        System.out.println(7 >> 1);
        //算数右移，假设存储单字节为8位，-7原码为1000 0111，补码为：1111 1001，无符号右移一位之后为 1111 1100，注意这里符号位1不动，但是移动到下一位是1，不是0
        //这个注意下，再按位取反+1得到原码： 1000 0100，值为-4
        System.out.println(-7 >> 1);
        //逻辑右移，把-7当做正数和算数右移一个效果，存储4字节32位，-7的原码是：10000000 00000000 00000000 00000111，补码是：11111111 11111111 11111111 11111001，
        //带着符号右移一位，成为：01111111 11111111 11111111 11111100，正好是整形最大数值-3,2147483647-3=2147483644
        System.out.println(-7 >>> 1);
    }
}
