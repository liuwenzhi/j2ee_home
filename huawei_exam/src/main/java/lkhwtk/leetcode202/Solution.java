package lkhwtk.leetcode202;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 参考题解：官方。本题官方视频质量一般，直接看文章解析。本题涉及到一定数学知识
 * 核心思路：创建一个集合Set，存储每次n各位平方和的结果，然后判断是否有重复的值，有就返回false，否则最后判断是否为1。
 * 官方题解中，分析结果可能存在三种情况，最终结果得到1，结果出现了环，结果无限大，结果无限大这种情况最终被排除了，不会出现。
 * 所以只有头两种情况。
 */
public class Solution {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        //判断在每次计算的过程中，是否会出现重复的值，出现了重复，则进入死循环
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
