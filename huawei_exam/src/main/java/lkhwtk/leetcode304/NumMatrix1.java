package lkhwtk.leetcode304;

/**
 * 参考题解：官方，建立二维前缀和思路
 * 优化思路：初始化矩阵的方法构造方法只调用一次，儿计算累加的方法会调用多次，可以增加构造方法的时间复杂度，
 * 借此来减少计算区域矩阵的时间复杂度。本算法是个人借鉴官方设计，效率相对也不高。一维前缀和非常不好理解，
 * 效率相对也不高，设置不如二维前缀和，暂时按照个人思路来吧。
 */
public class NumMatrix1 {

    /**
     * sum数组保留每一个元素的行前缀和（包括元素本身的累加和）
     */
    private int[][] prefix;

    public NumMatrix1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefix = new int[rows][cols];
        //题目提示中已经给出了矩阵的长宽范围在[1,200]，这里不单独验证数值
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(j==0){
                    //第一列累加和为元素自己
                    prefix[i][j] = matrix[i][j];
                }else{
                    //后边每一列累加和为前一个累加和+当前元素
                    prefix[i][j] = matrix[i][j]+prefix[i][j-1];
                }
            }
        }
    }

    /**
     * 求和：统计每一行和，然后累加
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        //注意：这里一定是<=row2
        for(int i=row1;i<=row2;i++){
            if(col1==0){
                //如果左侧是第0列，则直接找col2的行累加和
                sum += prefix[i][col2];
            }else {
                //如果左侧不是第0列，则需要做一个差：prefix[i][col2] - prefix[i][col1]实际会少一个元素prefix[i][col1]，这个元素需要prefix[i][col1]- prefix[i][col1 - 1]
                //把两个式子一加：prefix[i][col2] - prefix[i][col1]+prefix[i][col1]- prefix[i][col1 - 1] 就是：prefix[i][col2] - prefix[i][col1 - 1]
                sum += (prefix[i][col2] - prefix[i][col1 - 1]);
            }
        }
        return sum;
    }

    public static void main(String[] args){
        int[][] a ={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix1 numMatrix = new NumMatrix1(a);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
    }

}
