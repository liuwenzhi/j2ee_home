package lkhwtk.leetcode1198;

/**
 * 基于数组实现
 */
public class Solution1 {
    public int smallestCommonElement(int[][] mat) {
        //count数组中每一个位置的值代表位置数字出现次数的值，count[1]代表1出现的次数
        int count[] = new int[10001];
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ++count[mat[i][j]];
            }
        }
        //经过测试：在外边再一次遍历数组比在上边第二层for循环中判断能节省一半时间，从前往后直接找到就退出
        for (int k = 1; k <= 10000; ++k) {
            if (count[k] == n) {
                return k;
            }
        }
        return -1;


        /* 比对在第二层for循环中做值的判断
        int count[] = new int[10001];
        int n = mat.length, m = mat[0].length;
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                if (++count[mat[i][j]] == n) {
                    return mat[i][j];
                }
            }
        }
        return -1;
        */
    }
}
