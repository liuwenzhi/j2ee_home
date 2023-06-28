package lkhwtk.leetcode1111;

/**
 * 参考题解：官方
 * 核心思路：将嵌套深度为1,3的奇数层括号分配给A，嵌套深度为偶数层的2,4分配给B，平均分配做到嵌套深度最小
 * 非常巧的一个思路
 */
public class Solution1 {
    public int[] maxDepthAfterSplit(String seq) {
        int d = 0;
        int length = seq.length();
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            if (seq.charAt(i) == '(') {
                //左括号深度自增
                ++d;
                ans[i] = d % 2;
            } else {
                //右括号深度递减，注意这个设计：将奇数号深度的()放到一个数组中，偶数号的()放到一个数组中，if中是先增，再放，else右括号这里是先放，再减
                //这样设计是保证遇到有括号的时候，能够和最近的左括号的深度保持匹配
                ans[i] = d % 2;
                --d;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.maxDepthAfterSplit("(()())()"));
    }
}
