package lkhwtk.leetcode1018;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 * 一个有点绕的小知识点：
 * 举例说明：6÷ 2=3.我们就说6能被2整除,或者说2整除6.
 * 此题中.“某数能被5整除”,意思是用某数除以5得整数.这是正确的
 * 但是“20整除5”意思是用5除以20是整数.但这是错误的.所以两者不一样.
 * 参考题解：官方：本题实际使用到了一个小技巧，左移*2，
 * 参考题解：击败双100%！最容易理解的思路！这个题解是一个C++题解，主要是把%10这个思路拿过来，其实余5，按照官方的来也可以。
 * 就是避免累加数字过大
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int prefix = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //每次之前的prefix左移一位累加新的个位
            prefix = ((prefix << 1) + nums[i]);
            //这里余10很重要，避免超过整形数字表示范围，主要就是看是否是以0和5结尾，是的话就能整除5
            prefix = prefix % 10;
            answer.add(prefix % 5 == 0);
        }
        return answer;
    }

    /**
     * main方法演示了算法的核心思路：讲一个01整形数组，转成10进制数字的方式
     * 可以直接这么想：1*2，从二进制角度来看变成10,10后边再接个1就是11，相当
     * 于十进制的3后边思路类似
     */
    public static void main(String[] args){
        int[] nums = {1,1,0,1};
        int length = nums.length;
        int prefix = 0;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + nums[i]);
            System.out.println(prefix);
        }
    }

}
