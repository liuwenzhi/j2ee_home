package lkhwtk.leetcode836;

/**
 * 836. 矩形重叠
 * 注意本题和223题关联性很大
 */
public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1.length==0||rec2.length==0){
            return false;
        }
        //正常矩阵不存在相交的情况
        if(rec1[2]<=rec2[0]||rec1[3]<=rec2[1]||rec1[0]>=rec2[2]||rec1[1]>=rec2[3]){
            return false;
        }
        //注意本题的一个坑点：给的矩阵有可能构不成矩阵，可能是一条线比如输入用例：rec1 [-1,0,1,1] rec2 [0,-1,0,1]，223题如果给的矩形是一个点或者一条线，不影响计算结果
        if(rec1[0]==rec1[2]||rec1[1]==rec1[3]||rec2[0]==rec2[2]||rec2[1]==rec2[3]){
            return false;
        }
        return true;
    }
}
