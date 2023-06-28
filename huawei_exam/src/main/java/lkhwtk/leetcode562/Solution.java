package lkhwtk.leetcode562;

/**
 * 562. 矩阵中最长的连续1线段
 * 参考题解：官方 优化暴力法求解
 * 注意题意：连续1的长度可以是水平的，垂直的，对角线的，反对角线的，对角线的和反对角线的是指
 * 正45度或者反45度的斜线段，不一定非要在对角线上
 * 本题直接考虑经过优化后的暴力解法，二维动态规划实现需要建立四个二位矩阵，而且效率没有提升，
 * 一维动态规划方式能好一些，理解起来过于复杂。
 */
public class Solution {
    /**
     * 单独写一个方法，判断是否越界
     */
    private boolean overflow(int[][] M, int i, int j) {
        return i < 0 || j < 0 || i >= M.length || j >= M[0].length;
    }

    /**
     * 按照一个方向统计1的个数，如果遇到了0，则重新开始统计
     * 返回一个按照direction_i，direction_j方向上最长的连续1个数
     */
    private int count(int[][] M, int i, int j, int direction_i, int direction_j) {
        int ans = 0, cur = 0;
        while (!overflow(M, i, j)) {
            if (M[i][j] == 1) {
                ++cur;
                ans = Math.max(ans, cur);
            } else {
                cur = 0;
            }
            i += direction_i;
            j += direction_j;
        }
        return ans;
    }

    public int longestLine(int[][] M) {
        if (M.length == 0)
            return 0;
        int ans = 0;
        for (int i = 0; i != M.length; ++i) {
            // 左边界为起点，向右
            ans = Math.max(ans, count(M, i, 0, 0, 1));
            // 左边界为起点，向右下
            ans = Math.max(ans, count(M, i, 0, 1, 1));
            // 右边界为起点，向左下
            ans = Math.max(ans, count(M, i, M[0].length - 1, 1, -1));
        }
        for (int j = 0; j != M[0].length; ++j) {
            // 上边界为起点，向下
            ans = Math.max(ans, count(M, 0, j, 1, 0));
            // 上边界为起点，向右下
            ans = Math.max(ans, count(M, 0, j, 1, 1));
            // 上边界为起点，向左下
            ans = Math.max(ans, count(M, 0, j, 1, -1));
        }
        return ans;
    }

}
