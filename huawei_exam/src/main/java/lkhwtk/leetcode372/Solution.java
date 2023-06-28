package lkhwtk.leetcode372;

import java.util.Stack;

/**
 * 372. 超级次方
 * 纯数学问题，参考题解：官方
 * java语言参考题解：java递归实现
 * 算法也是背一下吧
 */
public class Solution {
    int base = 1337;
    public int superPow(int a, int[] b) {
        //将数组b中的元素放到一个stack里边，主要是方便从数组的后边往前取数据，每次直接取栈顶元素，然后按递归方式进行幂计算
        Stack<Integer> stack = new Stack<>();
        int n = b.length;
        for(int i = 0;i < n;i++){
            stack.push(b[i]);
        }
        return hpPow(a,stack);
    }
    /**
     * 递归实现幂计算，计算思路参考官方题解
     */
    public int hpPow(int a,Stack<Integer> stack){
        if(stack.isEmpty()){
            return 1;
        }
        int last = stack.pop();
        int part1 = myPow(a,last);
        int part2 = myPow(hpPow(a,stack),10);
        return (part1 * part2) % base;
    }
    /**
     * 计算 a 的 k 次方然后与 base 求模的结果
     * 优化取模，（a*b）%c = (a%c)*(b%c)%c，相当于对于每一个因子a和b，可以先%c，之后再做乘积，最后%c
     */
    public int myPow(int a,int k){
        int res = 1;
        a %= base;
        for(int i = 0;i < k;i++){
            // 这里有乘法，是潜在的溢出点
            res *= a;
            //对计算结果取余
            res %= base;
        }
        return res;
    }

}
