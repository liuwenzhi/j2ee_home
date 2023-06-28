package lkhwtk.leetcode799;

/**
 * 799. 香槟塔
 * 题解参考：Champagne Tower 官方
 * 解法非常经典
 */
public class Solution {
    /**
     * poured：倒入香槟总杯数
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        //数组初始化为101不是100，因为在100层香槟塔之外，香槟还可能会流到地上，多了一层计算，这个必须要考虑到
        //注意算法中：会用到根据第r层计算第r+1层流出的量A[r+1]，计算到第100层的时候（对应编号99行），还会统计下101层，即撒到地上的量
        //第二维度的长度可以设置为100，应该是测试用例中没有覆盖最后地上这一个行，最后一个位置
        double[][] A = new double[101][101];
        //最顶层第一个杯子先把全部倒入的量都存下（比如3，10，那么A[0][0]就存3和10，在接下来的for循环中对这个量进行处理，最终只保留1）
        A[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            //注意内层循环：第一层1个杯，第二层2个杯，内存循环实际是遍历当前层所有的杯
            for (int c = 0; c <= r; ++c) {
                //当前杯子装满了，再分别向下方相邻的两个杯子倒入，剩下的都倒出去
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r+1][c] += q;
                    A[r+1][c+1] += q;
                }
            }
        }
        //注意：一定要考虑到在数组中的元素可能大于1的情况，实际上此时香槟都流出去了
        return Math.min(1, A[query_row][query_glass]);
    }
}
