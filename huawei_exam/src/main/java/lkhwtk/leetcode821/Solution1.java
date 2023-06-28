package lkhwtk.leetcode821;

/**
 * 参考题解：官方
 * 左边找一遍，右边找一遍然后和左边比对下
 * 涉及到用Integer最大值，最小值进行计算的时候，可以参考下本题使用一半的方式，避免了计算溢出
 */
public class Solution1 {
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        //计算左侧的时候，prev是减数，让这MIN_VALUE个值是赋值尽可能的小，就能让不满足条件的计算结果尽可能的大
        int prev = Integer.MIN_VALUE / 2;

        //左边找一遍，记录下前缀位置
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C){
                prev = i;
            }
            ans[i] = i - prev;
        }

        //右边找一遍，得到最终结果，计算右侧的时候，prev是被减数，让MAX_VALUE这个值是赋值尽可能的大，就能让不满足条件的计算结果尽可能的大
        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) {
                prev = i;
            }
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

}
