package coder.NC86;

/**
 * NC86 矩阵元素查找
 * 本题思路很巧妙，矩阵行和列都有序，查找元素的时候从左下角开始查，不断往右上去找
 * 或者可以从右上开始找，总之保证往水平或者垂直方向找的时候，一个增加，一个减少
 */
public class Soluction {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int nn = n-1;
        int mm = 0;
        while(nn >= 0 && mm <= m-1){
            if(mat[nn][mm] == x)
                return new int[]{nn,mm};
                //如果此时元素大于目标值，则nn--，往上寻找
            else if(mat[nn][mm] > x)
                nn--;
                //如果此时元素小于目标值，则mm++，往右寻找
            else
                mm++;
        }
        return new int[]{};
    }
}
