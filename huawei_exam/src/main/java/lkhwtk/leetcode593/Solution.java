package lkhwtk.leetcode593;

/**
 * 593. 有效的正方形
 * 本题注意下：一定是四个点构成正方形，如果是三个点，即使是处于一个正方形的三个点也不行
 */
public class Solution {

    /**
     * 计算两个坐标之前连线的长度的平方（判断是正方形没必要再做开根号处理），这个值肯定是正数
     * 备注：dist在英文中代表距离函数
     */
    private int dist(int[] pA, int[] pB) {
        return (pA[1] - pB[1]) * (pA[1] - pB[1]) + (pA[0] - pB[0]) * (pA[0] - pB[0]);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //把四个点之间的六个距离连线拿出来
        int p12 = dist(p1,p2);
        int p13 = dist(p1,p3);
        int p14 = dist(p1,p4);
        int p23 = dist(p2,p3);
        int p24 = dist(p2,p4);
        int p34 = dist(p3,p4);
        //如果六个距离连线任意一个是0，则返回false
        if(p12==0||p13==0||p14==0||p23==0||p24==0||p34==0){
            return false;
        }
        //如果判断六条边四个相等，两个是其他四个的二倍，这个判断整理得非常精彩，只通过三个或就能够包含全部边比对的情况
        if(p12==p13 && p24==p34 && 2*p13==p23 && p23==p14 || p12==p14 && p23==p34 && 2*p14==p24 && p24==p13 || p13==p14 && p23==p24 && 2*p14==p34 && p34==p12)
            return true;
        return false;
    }
}
