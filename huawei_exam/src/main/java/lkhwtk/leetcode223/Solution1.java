package lkhwtk.leetcode223;

/**
 * 本题可以不用借助Math类，在直角坐标系中，右侧坐标的x值减去左侧坐标x值，
 * 上边坐标的y值减去下边坐标的y值，肯定大于0
 */
public class Solution1 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C-A)*(D-B) + (G-E)*(H-F);
        //两个矩形无交集，注意包括等于
        if(E>=C || G <=A || F >=D || B >=H){
            return total;
        }else{
            //两个矩形有交集，注意：左边下边left和bottom找大的，右边上边right和top坐标找小的，保证能找到可能存在的交集
            int left = Math.max(A,E);
            int bottom = Math.max(B,F);
            int right = Math.min(C,G);
            int top = Math.min(D,H);
            return total - (right-left)*(top-bottom);
        }
    }

    public static void main(String[] args){
        System.out.println(Math.max(2,2));
    }
}
